package enoteca;

public class Vino {
	public String nome;
	public int annata;
	public double prezzo;
	public String locazioneGeografica;
	public String produttore;
	public int inDeposito;
	public char valuta;
	private static final String DA_STAMPARE = "Nome: %s\t Annata: %d\t Prezzo %.2f\t Locazione geografica: %s\t Produttore: %s\t In deposito: %d\n";
	private static final double EU_TO_DO = 1.09;
	
	
	public Vino(String nomeVino, int annataVino, double prezzo2, String locazione, String produttore2, int inDeposito2, char valuta2){
		nome=nomeVino;
		annata=annataVino;
		prezzo=prezzo2;
		locazioneGeografica=locazione;
		produttore=produttore2;
		inDeposito=inDeposito2;
		valuta=valuta2;
	}
	
	public void stampaVino(){
		System.out.printf(DA_STAMPARE, nome, annata, prezzo, locazioneGeografica, produttore, inDeposito);
	}
	
	public String toString(){
		StringBuffer stampare = new StringBuffer(String.format(DA_STAMPARE, nome, annata, prezzo, locazioneGeografica, produttore, inDeposito));
		return stampare.toString();
	}
	
	public double guadagnoMultiValuta(char c){
		switch(c){
		case '$':
			if(c==valuta){
				System.out.println("Già in tale valuta!");
				break;
			}
			prezzo*=EU_TO_DO;
			System.out.println(prezzo);
			return prezzo;
		case '€':
			if(c==valuta){
				System.out.println("Già in tale valuta!");
				break;
			}
			prezzo/=EU_TO_DO;
			System.out.println(prezzo);
			return prezzo;
		}
		return -1;
	}
}
