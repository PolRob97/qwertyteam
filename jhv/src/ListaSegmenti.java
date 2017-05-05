import java.util.Vector;

public class ListaSegmenti {
	public Vector<Segmento> lista;
	
	public ListaSegmenti(){
		lista = new Vector<>();
	}
	
	public void aggSegmento(Segmento s){
		lista.add(s);
	}
	
	public void ordinaLista(){
		for(int i=0; i<lista.size(); i++){
			for(int j=0; j<lista.size(); j++){
				if(lista.get(i).distanza>lista.get(j).distanza){
					Segmento temp = lista.get(i);
					lista.set(i, lista.get(j));
					lista.set(j, temp);
				}
			}
		}
	}

}
