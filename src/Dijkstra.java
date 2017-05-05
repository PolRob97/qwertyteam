import java.util.Vector;

/**
 * Classe che fornisce i metodi per applicare ad un dato grafo l'algoritmo di Dijkstra.
 * @author Qwertyteam
 * @version 1.0
 */

public class Dijkstra {
	private Graph graph;
	private Double [] nodeDistances; 
	private Vector<Nodo> orderVisitedNodes;
	private int [] previousSteps;
	private MatriceAdiacenze matrix;
	
	/**
	 * Costruttore della classe.
	 * @param graph Grafo contenente i nodi del sistema.
	 * @param matrix Matrice delle adiacenze che fornisce i collegamenti fra i nodi e i rispettivi pesi.
	 */
	
	public Dijkstra(Graph graph, MatriceAdiacenze matrix){
		this.graph = graph;
		this.matrix = matrix;
		orderGraphByID(graph.nodes);
		orderVisitedNodes = new Vector<>();
		previousSteps = new int[graph.nodes.length];
		nodeDistances = new Double[graph.nodes.length];
	}
	
	/**
	 * Metodo che permette di eseguire l'algoritmo di Dijkstra sul grafo.
	 */
	
	public void executeAlgorithm(){
		
		/*
		 * Fase iniziale: assegnamento. Tutte le distanze potenziali tra i nodi vengono settate 
		 * ad infinito. Inoltre l'array che tiene traccia dei nodi precedenti già visitati è settato
		 * a null dalla JVM.
		 */
		
		for(Nodo node : graph.nodes){
			nodeDistances[node.getIDNode()] = Double.POSITIVE_INFINITY;
		}
		
		nodeDistances[0] = 0.0;
		previousSteps[0] = 0;
		
		/*
		 * Fase intermedia: ciclo principale. Il ciclo non si interrompe finchè c'è un blocco nel
		 * grafo causato da nodi irraggiungibili oppure se è stato raggiunto il nodo di destinazione.
		 * 
		 */
		
		while(true){
			int indexNode = getIndexOfMinimumNodeDistance(); //imposta l'indice del nodo che ha distanza minore
			if(nodeDistances[indexNode] == Double.POSITIVE_INFINITY) //se il grafo presenta nodi irraggiungibili
				break;
			orderVisitedNodes.addElement(graph.nodes[indexNode]); //aggiungi il nodo alla lista dei nodi visitati
			if(graph.nodes[indexNode].isDestinationNode()){ //se si tratta del nodo di destinazione
				printOrderVisitedNodes();
				printShortestPath(indexNode);
				break;
			}
			
			graph.nodes[indexNode] = null; //libera la memoria
			
			/*
			 * Fase importante: ciclo interno. Viene eseguito per ogni nodo adiacente a quello che ha
			 * distanza minore. La variabile alt tiene in memoria il costo per raggiungere il nodo adiacente
			 * a partire dal nodo iniziale. Se il costo contenuto nella variabile è minore del costo 
			 * che il nodo aveva precedentemente esso viene aggiornato. Se la condizione è vera viene 
			 * registrato il passo per arrivare al nodo adiacente (ossia si tiene conto del nodo che ha 
			 * permesso di raggiungere quello adiacente con il meno costo possibile).
			 */
			
			for(int indexLinkedNode : matrix.getIndexesOfLinkedNodes(indexNode, orderVisitedNodes)){
				double temporaryWeight = nodeDistances[indexNode] + matrix.getAdjacencyMatrix()[indexNode][indexLinkedNode];
				if(temporaryWeight < nodeDistances[indexLinkedNode]){
					nodeDistances[indexLinkedNode] = temporaryWeight;
					previousSteps[indexLinkedNode] = indexNode;
				}
			}
			nodeDistances[indexNode] = null; //libera la memoria
		}
		
		
	}
	
	/**
	 * Metodo che permette di scegliere il nodo che ha distanza minore tra quelli non ancora visitati.
	 * @return Indice del nodo scelto.
	 */
	
	public int getIndexOfMinimumNodeDistance(){
		int indexNodeWithMinimumValue = -1;
		double minimumValue = 0;
		boolean isMinimumValueAssigned = false;
		for(int index = 0; index < nodeDistances.length; index++){
			if(nodeDistances[index]!= null && isMinimumValueAssigned == false){ //se si tratta del primo elemento non null della lista
				indexNodeWithMinimumValue = index; //registralo come possibile valore minimo dell'array
				minimumValue = nodeDistances[index];
				isMinimumValueAssigned = true;
				continue;
			}
			
			/*Se ci sono altri elementi non null nell'array questa condizione permette di stabilire
			 * l'elemento con il minor valore dell'array.
			 */
			
			if(nodeDistances[index]!= null && minimumValue > nodeDistances[index]){ 
				indexNodeWithMinimumValue = index;
				minimumValue = nodeDistances[index];
			}
		}
		return indexNodeWithMinimumValue;
	}
	
	/**
	 * Metodo che permette di riordinare il grafo in ordine crescente di ID. Importante ricordare che
	 * il nodo con ID = 0 è sempre il nodo sorgente. L'algoritmo utilizzato non è nient'altro che il 
	 * Bubble-Sort.
	 * @param graph Il grafo da riordinare
	 */
	
	public static void orderGraphByID(Nodo [] graph){
		for(int index = 0; index < graph.length; index++) {
            boolean flag = false;
            for(int j = 0; j < graph.length-1; j++) {
                if(graph[j].getIDNode() >graph[j+1].getIDNode()) {
                    Nodo node = graph[j];
                    graph[j] = graph[j+1];
                    graph[j+1] = node;
                    flag=true; //Lo setto a true per indicare che é avvenuto almeno uno scambio
                }
            }
            
            /*
             * Se flag=false allora vuol dire che nell' ultima iterazione non ci sono stati scambi, quindi 
             * il metodo può terminare poiché l' array risulta essere ordinato
             */
            if(!flag) break;                      
        }
	}
	
	/**
	 * Metodo che permette la stampa a schermo di tutti i nodi del grafo visitati dall'algoritmo.
	 */
	
	private void printOrderVisitedNodes(){
		System.out.println("L'ordine dei nodi visitati è: ");
		for(Nodo node : orderVisitedNodes)
			System.out.print(node.getLabel() + "-");
		System.out.println();
	}
	
	/**
	 * Metodo che permette la stampa a schermo dell'albero dei cammini minimi del grafo.
	 * @param idNode ID del nodo di destinazione.
	 */
	
	private void printShortestPath(int idNode){
		System.out.print("Albero dei cammini minimi: " + searchNodeByID(idNode).getLabel() + "-");
		boolean isSource = false;
		for(int index = idNode; index != 0 && !isSource;){
			index = previousSteps[index];
			if(index == 0)
				isSource = true;
			System.out.print(searchNodeByID(index).getLabel() + "-");
			
		}
	}
	
	/**
	 * Ricerca nel Vector dei nodi visitati il nodo, dato l'ID.
	 * @param idNode ID del nodo da ricercare
	 * @return Nodo se la ricerca è andata a buon fine, altrimenti null.
	 */
	
	private Nodo searchNodeByID(int idNode){
		for(Nodo node : orderVisitedNodes){
			if(node.getIDNode() == idNode)
				return node;
		}
		return null;
	}
}
