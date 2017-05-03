package krucals;

import java.util.Vector;

public class Ramo {
	private static final String NO_DEL = "Impossibile potare ramo";
	//private static final String NO_PROX = "Non è presente un nuovo ramo vicino";
	
	public Vector<Nodo> ramo;
	public int pesoRamo;
	
	public Ramo(){
		ramo = new Vector<>();
		pesoRamo = 0;
	}
	
	public void aggPunto(Nodo p1){
		ramo.add(p1);
		if(ramo.size()>1){
			pesoRamo+=ramo.get(ramo.size()-2).distanze[p1.x];//Add the distance(weight) to the total weight of the ramo
		}
	}
	
	public int posPunto(Nodo p1){
		for(int i=0; i<ramo.size(); i++){
			if(ramo.get(i).equals(p1)) return i;
		}
		return -1;
	}
	
	public void potaRamo(Nodo p1){
		int posPota=posPunto(p1);
		if(posPota==-1){
			System.out.println(NO_DEL);
		}else for(int i=ramo.size()-1; i>=posPota; i--){
			pesoRamo-=ramo.get(i).distanze[i-1];
			ramo.remove(i);
		}
	}
	
	public Nodo possibileProssimo(int gradoMinimo){
		return ramo.get(ramo.lastElement().puntoVicino(gradoMinimo));
	}
	
	public boolean doppioPunto(Nodo ricercato){
		for(Nodo p: ramo)
			if(p.equals(ricercato)) return true;
		return false;
	}
	

}
