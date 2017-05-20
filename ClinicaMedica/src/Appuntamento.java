import java.time.LocalDateTime;

public class Appuntamento {
	private static final String INIZIO = "Inizio appuntamento: ";
	private static final String FINE = "Fine appuntamento: ";
	private static final String URGENZA = "Livello urgenza: ";
	private enum urgenza {
		ROSSO,
		GIALLO,
		NERO,
		MARRONE,
	}
	private urgenza urgenza;
	private LocalDateTime inizio;
	private LocalDateTime fine;
	
	public LocalDateTime getInizio(){
		return inizio;
	}
	
	public LocalDateTime getFine(){
		return fine;
	}
	
	public urgenza getUrgenza(){
		return urgenza;
	}
	
	public String toString(){
		StringBuffer descrizione = new StringBuffer();
		descrizione.append(INIZIO+inizio+FINE+fine+URGENZA+urgenza);
		return descrizione.toString();
	}
	

}
