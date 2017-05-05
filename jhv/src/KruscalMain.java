
public class KruscalMain {

	public static void main(String[] args) {
		int dim = 6, n=0;
		ListaNodi listaNodi = new ListaNodi();
		Collegamenti matColleg = new Collegamenti(dim);
		ListaSegmenti listaSeg = new ListaSegmenti();
		while(n<6){//aggiunge nodi alla lista dei nodi
			Nodo nodo = listaNodi.creaNodo(dim);
			listaNodi.aggNodo(nodo);
		}

	}

}
