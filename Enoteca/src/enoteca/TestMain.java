package enoteca;

//import java.util.ArrayList;

import it.unibs.fp.mylib.MyMenu;

public class TestMain {
	private static final String[] vociMenu = {"Stampa lista vini", "Numero di bottiglie per ogni vino", "Numero di bottiglie per ogni produttore", "Guadagno in multi-valuta", "Vini compresi in una certa fascia di annata", "Aggiungi vino", "Test"};
	private static final String NOME_ENOTECA = "Mia Enoteca";

	public static void main(String[] args) {
		boolean uscita=false;
		ListaVini lista = new ListaVini();
		MyMenu menu = new MyMenu(NOME_ENOTECA, vociMenu);
		while(!uscita){
			switch(menu.scegli()){
			case 1:
				lista.ordineAlfabetico();
				lista.stampaVini();
				break;
			case 2:
				lista.ordineDeposito();
				break;
			case 3:
				lista.ordineProduttore();
				//lista.stampaVini();
				break;
			case 5:
				ListaVini compresiAnnata = new ListaVini();
				compresiAnnata = lista.compresiAnnata();
				compresiAnnata.stampaVini();
				break;
			case 4:
				lista.multiValuta();
				break;
			case 6:
				lista.aggVino();
				break;
			case 7:
				lista.stampatutto();//info su toString
				break;
			default:
				uscita = true;
				break;		
			}
		}

	}

}
