
public class Nodo {
	
	public char nome;
	public boolean collegato;
	public char[] collegatoA;
	
	public Nodo(char nome, int totPunti){
		this.nome=nome;
		collegato = false;
		collegatoA = new char[totPunti-1];
	}
	
	public void puntoCollegato(){
		collegato = true;
	}

}
