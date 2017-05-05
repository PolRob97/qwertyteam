import java.util.Arrays;
import java.util.Vector;

public class Ramo {
	private static final String NO_DEL = "Impossibile potare ramo";
	//private static final String NO_PROX = "Non è presente un nuovo ramo vicino";
	
	public Vector<Nodo> nodiCollegati; //nodi collegati al nodo in questione
	public int pesiNodi[]; // distanze dei rispettivi nodi
	
	public Ramo(){
		
	}
	
	public Ramo(Vector<Nodo> nodiCollegati){
		this.nodiCollegati = nodiCollegati;
		pesiNodi = new int [nodiCollegati.size()];
	}
	
	public void aggiungiNodo(Nodo nodo, int pesoNodo){
		nodiCollegati.add(nodo);
		Arrays.copyOf(pesiNodi, pesiNodi.length + 1);
		pesiNodi[pesiNodi.length-1] = pesoNodo;
	}
	
	/*public int posPunto(Nodo p1){
		for(int i=0; i<ramo.size(); i++){
			if(ramo.get(i).equals(p1)) return i;
		}
		return -1;
	}*/
	
	/*public void potaRamo(Nodo p1){
		int posPota=posPunto(p1);
		if(posPota==-1){
			System.out.println(NO_DEL);
		}else for(int i=ramo.size()-1; i>=posPota; i--){
			pesoRamo-=ramo.get(i).distanze[i-1];
			ramo.remove(i);
		}
	}*/
	
	/*public Nodo possibileProssimo(int gradoMinimo){
		return ramo.get(ramo.lastElement().puntoVicino(gradoMinimo));
	}*/
	
	/*public boolean doppioPunto(Nodo ricercato){
		for(Nodo p: ramo)
			if(p.equals(ricercato)) return true;
		return false;
	}*/
	

}
