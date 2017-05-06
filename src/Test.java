import java.util.Vector;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World!");
		
		/*
		 * Creazione dei nodi del grafo!
		 */
		
		//Nodo nodoA = new Nodo(0, 'A');
		//Nodo nodoB = new Nodo(1, 'B');
		Nodo nodoC = new Nodo(0, 'C');
		Nodo nodoD = new Nodo(1, 'D');
		
		Nodo nodoE = new Nodo(2, 'E');
		Nodo nodoF = new Nodo(3, 'F');
		//Nodo nodoG = new Nodo(6, 'G');
		nodoD.setAsDestinationNode();
		
		/*
		 * Aggiunta dei nodi al Grafo!
		 */
		Vector<Nodo> nodes = new Vector<Nodo>(4);
		nodes.add(nodoF);
		nodes.add(nodoC);
		nodes.add(nodoE);
		nodes.add(nodoD);
		
		
		/*
		 * Creazione dei rami che collegano i vari nodi
		 */
		
		MatriceAdiacenze matrix = new MatriceAdiacenze(nodes.size());
		/*matrix.collegaNodi(nodoA.getIDNodo(), nodoB.getIDNodo(), 2);
		matrix.collegaNodi(nodoA.getIDNodo(), nodoC.getIDNodo(), 8);
		matrix.collegaNodi(nodoD.getIDNodo(), nodoC.getIDNodo(), 2);
		matrix.collegaNodi(nodoB.getIDNodo(), nodoE.getIDNodo(), 5);
		matrix.collegaNodi(nodoB.getIDNodo(), nodoD.getIDNodo(), 2);
		matrix.collegaNodi(nodoE.getIDNodo(), nodoG.getIDNodo(), 8);
		matrix.collegaNodi(nodoC.getIDNodo(), nodoF.getIDNodo(), 5);
		matrix.collegaNodi(nodoD.getIDNodo(), nodoF.getIDNodo(), 7);
		matrix.collegaNodi(nodoF.getIDNodo(), nodoG.getIDNodo(), 2);*/
		
		/*matrix.collegaNodi(nodoA.getIDNodo(), nodoC.getIDNodo(), 4);
		matrix.collegaNodi(nodoA.getIDNodo(), nodoD.getIDNodo(), 3);
		matrix.collegaNodi(nodoC.getIDNodo(), nodoE.getIDNodo(), 2);
		matrix.collegaNodi(nodoE.getIDNodo(), nodoB.getIDNodo(), 7);
		matrix.collegaNodi(nodoD.getIDNodo(), nodoB.getIDNodo(), 6);
		matrix.collegaNodi(nodoD.getIDNodo(), nodoE.getIDNodo(), 1);
		nodoB.setAsDestinationNode();*/
		
		matrix.linkNode(nodoC.getIDNode(), nodoD.getIDNode(), 6);
		matrix.linkNode(nodoC.getIDNode(), nodoF.getIDNode(), 1);
		matrix.linkNode(nodoF.getIDNode(), nodoE.getIDNode(), 1);
		matrix.linkNode(nodoE.getIDNode(), nodoD.getIDNode(), 1);
		
		Graph graph = new Graph(nodes, matrix);
		
		/*
		 * Stampa di prova a schermo della matrice delle adiacenze
		 */
		
		for(int i = 0; i < matrix.getAdjacencyMatrix().length; i++){
			for(int j = 0; j < matrix.getAdjacencyMatrix().length; j++)
				System.out.print("\t" + matrix.getAdjacencyMatrix()[i][j]);
			System.out.println();
		}
		
		
		/*
		 * Applicazione dell'algoritmo di Dijkstra
		 */
		Dijkstra dijkstra = new Dijkstra(graph);
		dijkstra.executeAlgorithm();
	}

}
