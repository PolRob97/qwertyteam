import java.util.Vector;

public class Test {

	public static void main(String[] args) throws CloneNotSupportedException{
		/*
		 * Creazione dei nodi del grafo!
		 */
		
		Nodo nodoA = new Nodo('A');
		nodoA.setAsSourceNode();
		Nodo nodoB = new Nodo(1, 'B');
		Nodo nodoC = new Nodo(4, 'C');
		Nodo nodoD = new Nodo(2, 'D');
		Nodo nodoE = new Nodo(5, 'E');
		Nodo nodoF = new Nodo(3, 'F');
		Nodo nodoG = new Nodo(6, 'G');
		nodoG.setAsDestinationNode();
		
		/*
		 * Aggiunta dei nodi al Grafo!
		 */
		Vector<Nodo> nodes = new Vector<Nodo>(7);
		nodes.add(nodoA);
		nodes.add(nodoB);
		nodes.add(nodoF);
		nodes.add(nodoC);
		nodes.add(nodoE);
		nodes.add(nodoD);
		nodes.add(nodoG);

		/*
		 * Creazione dei rami che collegano i vari nodi
		 */
		
		MatriceAdiacenze matrix = new MatriceAdiacenze(nodes.size(), false);
		matrix.linkNode(nodoA.getIDNode(), nodoB.getIDNode(), 2);
		matrix.linkNode(nodoA.getIDNode(), nodoC.getIDNode(), 8);
		matrix.linkNode(nodoD.getIDNode(), nodoC.getIDNode(), 2);
		matrix.linkNode(nodoB.getIDNode(), nodoE.getIDNode(), 5);
		matrix.linkNode(nodoB.getIDNode(), nodoD.getIDNode(), 2);
		matrix.linkNode(nodoE.getIDNode(), nodoG.getIDNode(), 8);
		matrix.linkNode(nodoC.getIDNode(), nodoF.getIDNode(), 5);
		matrix.linkNode(nodoD.getIDNode(), nodoF.getIDNode(), 7);
		matrix.linkNode(nodoF.getIDNode(), nodoG.getIDNode(), 2);
		
		Graph graph = new Graph(nodes, matrix);
		/*
		 * Applicazione dell'algoritmo di Dijkstra
		 */
		Dijkstra dijkstra = new Dijkstra(graph);
		dijkstra.executeAlgorithm();
	}

}
