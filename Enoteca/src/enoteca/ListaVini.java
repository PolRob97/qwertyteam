package enoteca;

import java.util.ArrayList;

import it.unibs.fp.mylib.InputDati;
//import java.util.Arrays;

public class ListaVini {
	private static final String ANNATA_INIZIO = "Inserire l'inizio della fascia di annate";
	private static final String ANNATA_FINE = "Inserire la fine della fascia di annate";
	private static final String ALTRA_VALUTA = "Inserire l'altra valuta";
	private static final String STAMPA_VINO = "Nome: &s\tProduttore: %s\tBottiglie rimaste: %d";
	private static final String STAMPA_VINO_D = "Nome: &s\tBottiglie rimaste: %d";
	private static final String ERRORE_VALUTA = "Valuta inserita errata!";

	
	ArrayList<Vino> lista;
	
	public ListaVini(){
		lista = new ArrayList<>();
	}
	
	public void aggVino(){
		String nome = InputDati.leggiStringaNonVuota("Inserisci nome vino:");
		int annata = InputDati.leggiInteroConMinimo("Inserisci l'anno del vino: ", 0);
		double prezzo = InputDati.leggiDoubleConMinimo("Inserisci prezzo: ", 0);
		String locazione = InputDati.leggiStringaNonVuota("Inserisci la regione di provenienza: ");
		String produttore = InputDati.leggiStringaNonVuota("Nome produttore: ");
		int inDeposito = InputDati.leggiIntero("Numero bottiglie in deposito: ");
		char c = InputDati.leggiChar("Inserisci la valuta del prezzo: ");
		Vino vino = new Vino(nome, annata, prezzo,locazione, produttore, inDeposito, c);
		lista.add(vino);
	}
	
	public ArrayList<Vino> ordineAlfabetico(){
		for(int i=0; i<lista.size(); i++){
			for(int j=0; j<lista.size(); j++){
					if(lista.get(i).nome.compareToIgnoreCase(lista.get(j).nome)==1){
						Vino temp = lista.get(i);
						lista.set(i, lista.get(j));
						lista.set(j, temp);
					}
			}
		}
		return lista;
	}
		
	public void ordineProduttore(){
		for(int i=0; i<lista.size(); i++){
			for(int j=0; j<lista.size(); j++){
				if(lista.get(i).produttore.compareToIgnoreCase(lista.get(j).produttore)==1){
					Vino temp = lista.get(i);
					lista.set(i, lista.get(j));
					lista.set(j, temp);
				}
			}
			System.out.printf(STAMPA_VINO, lista.get(i).nome, lista.get(i).produttore, lista.get(i).inDeposito);
		}
		//return lista;
	}
	
	public ArrayList<Vino> ordineRegione(){
		for(int i=0; i<lista.size(); i++){
			for(int j=0; j<lista.size(); j++){
					if(lista.get(i).locazioneGeografica.compareToIgnoreCase(lista.get(j).locazioneGeografica)==1){
						Vino temp = lista.get(i);
						lista.set(i, lista.get(j));
						lista.set(j, temp);
					}
			}
		}
		return lista;
	}
	
	public ArrayList<Vino> ordineAnnata(){
		for(int i=0; i<lista.size(); i++){
			for(int j=0; j<lista.size(); j++){
				if(lista.get(i).annata>lista.get(j).annata){
					Vino temp = lista.get(i);
					lista.set(i, lista.get(j));
					lista.set(j, temp);
				}
			}
		}
		return lista;
	}
	
	public ArrayList<Vino> ordinePrezzo(){
		for(int i=0; i<lista.size(); i++){
			for(int j=0; j<lista.size(); j++){
				if(lista.get(i).prezzo>lista.get(j).prezzo){
					Vino temp = lista.get(i);
					lista.set(i, lista.get(j));
					lista.set(j, temp);
				}
			}
		}
		return lista;
	}
	
	public void ordineDeposito(){
		for(int i=0; i<lista.size(); i++){
			for(int j=0; j<lista.size(); j++){
				if(lista.get(i).inDeposito>lista.get(j).inDeposito){
					Vino temp = lista.get(i);
					lista.set(i, lista.get(j));
					lista.set(j, temp);
				}
			}
			System.out.printf(STAMPA_VINO_D, lista.get(i).nome, lista.get(i).inDeposito);
		}
	}
	
	
	
	public int valutaIntero(int k){
		if(k==1 || k==2 || k==3) return 1;
		if(k==4 || k==5 || k==6) return -1;
		else return 0;
	}
	
	/*public ArrayList<Vino> ordina(int k){
		int valutazione = valutaIntero(k);
		switch(valutazione){
		case 1:
			
		}
	}*/
	
	
	
	
	public void stampaVini(){
		for(int i=0; i<lista.size(); i++){
			Vino vino = lista.get(i);
			vino.stampaVino();
		}
	}
		
	public ListaVini compresiAnnata(){
		ListaVini compresi = new ListaVini();
		int annataInizio = InputDati.leggiInteroConMinimo(ANNATA_INIZIO, 0);
		int annataFine = InputDati.leggiInteroConMinimo(ANNATA_FINE, annataInizio);
		for(int i=0; i<lista.size(); i++){
			if(lista.get(i).annata>=annataInizio&&lista.get(i).annata<=annataFine){
				compresi.lista.add(lista.get(i));
			}
		}
		return compresi;
	}
	
	public void multiValuta(){
		char c;
		do{
			c = InputDati.leggiChar(ALTRA_VALUTA);
			if(lista.get(0).guadagnoMultiValuta(c)==-1) System.out.println(ERRORE_VALUTA);
		}while(lista.get(0).guadagnoMultiValuta(c)==-1);
		for(int i=0; i<lista.size(); i++){
			lista.get(i).guadagnoMultiValuta(c);
		}
	}
	
	public void stampatutto(){
		for(int i=0; i<lista.size();i++){
			System.out.println(lista.get(i).toString());
		}
	}

}
