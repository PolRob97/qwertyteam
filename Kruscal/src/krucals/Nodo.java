package krucals;

import it.unibs.fp.mylib.InputDati;

public class Nodo {
	
	private static final String N_PUNTO = "Punto n.";
	private static final String DOM_DISTANZA = " quanto dista?";
	private static final String Q_DISTANZE = " rispetto a %d dista %d";
	private static final String COINCIDE = "Il punto coincide";
	private static final String OLTRE_LIM = "Superata lunghezza lista distanze";
	
	public int x;
	
	public Nodo(int x2){
		x = x2;
	}
	
	public void aggDistanze(double[] distanze){//Adds distance to the point
		System.out.println(N_PUNTO+x);
		for(int i=0; i<distanze.length; i++){
			if(x==(i+1)){
				distanze[i]=0;
			} else distanze[i]=InputDati.leggiIntero((i+1)+DOM_DISTANZA);
		}
	}
	
	public void leggiDistanze(double[] distanze){//Prints all distance 
		System.out.print(N_PUNTO+x);
		for(int i=0; i<distanze.length; i++){
			if(x==(i+1)) continue;
			System.out.printf(Q_DISTANZE, i+1, distanze[i]);
		}
	}
	
	public double prendiDistanza(int puntoDistanza, double[] distanze){//Returns the distance from a point
		if(puntoDistanza==x){
			System.out.println(COINCIDE);
			return 0;
		}
		if(puntoDistanza>distanze.length)
			System.out.println(OLTRE_LIM);
		return distanze[puntoDistanza];
	}
	
	public int puntoVicino(int gradoMinimo, double[] distanze){//Returns the nearest point 
		double minimo = distanze[0];
		if(gradoMinimo>distanze.length) System.out.println("GradoMinimo troppo elevato");
		for(int i=0; i<distanze.length; i++){
			if(x==(i+1)) continue;
			if(distanze[i]<minimo){
				minimo = distanze[i];
				gradoMinimo--;
			}
			if(gradoMinimo==0) return i+1;
		}
		return 1;
	}

}
