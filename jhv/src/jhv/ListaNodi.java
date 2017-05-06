package jhv;
import java.util.Vector;

import it.unibs.fp.mylib.InputDati;

public class ListaNodi {
	
	public static final String ERR_VUOTA = "Errore lista vuota";
	
	public Vector<Nodo> listaNodi;
	
	public ListaNodi(){
		listaNodi = new Vector<>();
	}

	public Nodo creaNodo(int totPunti){
		int nome = InputDati.leggiIntero("nome: ");
		Nodo n = new Nodo(nome, totPunti);
		return n;
	}
	
	public void aggNodo(Nodo n, Collegamenti coll){
		for(int i=0; i<n.collegatoA.length; i++){
			int numeroPunto = ((int) n.nome)-97;
			coll[numeroPunto][i]=InputDati.leggiDoubleConMinimo("distanza"+(char)i, 0);
		}
		listaNodi.add(n);
	}
	
	public Nodo cercaNodo(char daCercare){
		if(listaNodi.size()==0) System.out.println(ERR_VUOTA);
		for(int i=0; i<listaNodi.size(); i++){
			if(listaNodi.get(i).nome==daCercare) return listaNodi.get(i);
		}
		return null;
	}
}
