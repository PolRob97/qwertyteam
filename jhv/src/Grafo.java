import java.util.Vector;

public class Grafo {
	private static final String NO_UNIONE = "Il segmento non ha punti in comune con il grafo";
	public static final String ERR_VUOTA = "Liista vuota";

	public Vector<Nodo> grafo;
	
	public Grafo(){
		grafo = new Vector<Nodo>();
	}
	
	public Nodo cercaNodo(char nomeDaTrovare){
		if(grafo.size()==0) System.out.println(ERR_VUOTA);
		for(int i=0; i<grafo.size(); i++){
			if(grafo.get(i).nome==nomeDaTrovare) return grafo.get(i);
		}
		return null;
	}
	
	public void aggSegmento(Segmento a, ListaNodi lista){
		char A = a.unisce[0];
		char B = a.unisce[1];
		if(grafo.size()==0){
			System.out.println("Primo segmento!");
			grafo.add(lista.cercaNodo(A));
			grafo.add(lista.cercaNodo(B));
			Nodo n = lista.cercaNodo(A);
			n.puntoCollegato();
			Nodo n2 = lista.cercaNodo(B);
			n2.puntoCollegato();
			
		}
		Nodo inizio = cercaNodo(A);
		Nodo sInizio = null;
		if(inizio==null) sInizio = cercaNodo(B);
		if(inizio==null && sInizio==null) System.out.println(NO_UNIONE);
		if(inizio==null && sInizio==grafo.lastElement()){
			grafo.add(lista.cercaNodo(A));
			Nodo n = lista.cercaNodo(A);
			n.puntoCollegato();
		}
		if(inizio==grafo.lastElement() && sInizio==null){
			grafo.add(lista.cercaNodo(B));
			Nodo n = lista.cercaNodo(B);
			n.puntoCollegato();
		}
		
	}

}
