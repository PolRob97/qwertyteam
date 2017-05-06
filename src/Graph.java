import java.util.Vector;

public class Graph {
	public Nodo [] nodes;
	public MatriceAdiacenze matrix;
	
	public Graph(Vector<Nodo> nodes, MatriceAdiacenze matrix){
		this.nodes = new Nodo [nodes.size()];
		nodes.toArray(this.nodes);
		this.matrix = matrix;
		orderGraphByID(this.nodes);
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
}
