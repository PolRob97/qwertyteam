
public class Segmento {
	
	public char[] unisce;
	public double distanza;
	
	public Segmento(){
		unisce = new char[2];
		distanza = 0;
	}
	
	public void impostaSegmento(Nodo a, Nodo b, Collegamenti mat){
		distanza = mat.cercaDistanza(a, b);
		unisce[0] = a.nome;
		unisce[1] = b.nome;
	}

}
