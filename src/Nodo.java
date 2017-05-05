/**
 * Classe che rappresenta un singolo nodo di un grafo.
 * @author qwertyteam
 * @version 1.0
 */

public class Nodo {
	private boolean isDestination;
	private int idNode;
	private char label;
	
	/**
	 * Costruttore.
	 */
	
	public Nodo(int idNode, char label){
		this.idNode = idNode;
		this.label = label;
		
	}
	
	/**
	 * Metodo per ricavare l'ID del nodo.
	 * @return ID del nodo
	 */
	public int getIDNode(){
		return idNode;
	}
	
	/**
	 * Metodo per ricavare l'etichetta del nodo.
	 * @return Etichetta del nodo
	 */
	public char getLabel(){
		return label;
	}
	
	/**
	 * Metodo che permette di restituire se il nodo è di destinazione o meno.
	 * @return True se è di destinazione, false altrimenti.
	 */
	
	public boolean isDestinationNode(){
		return isDestination;
	}
	
	/**
	 * Setta il nodo a nodo destinazione.
	 */
	
	public void setAsDestinationNode(){
		isDestination = true;
	}
}
