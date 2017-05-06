import java.util.Arrays;
import java.util.Vector;

/**
 * Classe che permette di modellizzare una matrice delle adiacenze che tiene conto dei collegamenti tra
 * i vari nodi e i rispettivi pesi.
 * @author qwertyteam
 * @version 1.0
 */

public class MatriceAdiacenze {
	private double[][] adjacencyMatrix;
	
	/**
	 * Costruttore della classe.
	 * @param totalNodes Numero totale dei nodi che compongono la matrice.
	 */
	
	public MatriceAdiacenze(int totalNodes){
		adjacencyMatrix = new double[totalNodes][totalNodes];
	}
	
	/**
	 * Metodo che permette di settare le diagonali a zero, essendo che la distanza tra un nodo e 
	 * sè stesso è per definizione zero.
	 * @param totalNodes Numero totale dei nodi che compongono la matrice.
	 */
	
	public void prepareMatrix(int totalNodes){
		for(int i = 0; i < adjacencyMatrix.length; i++){
			adjacencyMatrix[i][i] = 0;
		}
	}
	
	/**
	 * Metodo che permette di collegare simmetricamente due nodi.
	 * @param startNode Nodo di partenza
	 * @param endNode Nodo di destinazione
	 * @param weight Peso del collegamento tra i due nodi.
	 */
	
	public void linkNode(int startNode, int endNode, int weight){
		adjacencyMatrix[startNode][endNode] = weight;
		adjacencyMatrix[endNode][startNode] = weight;
	}
	
	/**
	 * Metodo che permette di restituire la matrice di adiacenza.
	 * @return Matrice di adiacenza.
	 */
	
	public double [][] getAdjacencyMatrix(){
		return adjacencyMatrix;
	}
	
	/**
	 * Metodo che, dato l'id di un nodo, permette di restituire i nodi degli ID collegati ad esso,
	 * ma non ancora visitati.
	 * @param idNode ID del nodo iniziale.
	 * @param visitedNodes Lista dei nodi già visitati
	 * @return Lista degli ID dei nodi collegati al nodo iniziale e non ancora visitati.
	 */
	
	public int [] getIndexesOfLinkedNodes(int idNode){
		int indexArray = 0;
		int [] indexesOfLinkedNodes = new int[0];
		for(int j = 0; j < adjacencyMatrix.length; j++){
			if(adjacencyMatrix[idNode][j] != 0){ //se il nodo è collegato
				indexArray++;
				indexesOfLinkedNodes = Arrays.copyOf(indexesOfLinkedNodes, indexArray); //rimodellizza dimensione array
				indexesOfLinkedNodes[indexArray-1] = j; //memorizza idNodo (che coincide con l'index "j")
			}	
		}
		return indexesOfLinkedNodes;
	}
}
