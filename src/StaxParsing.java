/*
 * Il codice legge un file xml e semplicmente lo ricopia senza indentazione, ovviamente bisogner� semplicemente
 * sostituire la parte in cui scrivo nel buffer con quello che ci servir� realmente fare.
*/
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class StaxParsing {
	public StringBuffer processXMLFile(File xMLFile) throws FileNotFoundException, XMLStreamException, FactoryConfigurationError {
		XMLEvent xMLEvent = null; // sarebbe la riga che sto leggendo 
		Characters characters = null; // <qualcosa> "quello che c'� scritto qua" </qualcosa>
		StringBuffer rawXML = new StringBuffer(); // il buffer in cui copio quello che leggo
		boolean meta = true; //variabile che ho utilizzato per capire se ho raggiunto la struttura ad albero o meno
		XMLEventReader xMLEventReader = XMLInputFactory.newInstance().createXMLEventReader(new FileInputStream(xMLFile));
		
		/* esistono 3 tipi di casi:
		 * <START_ELEMENT>
		 * <qualcosa> CHARACTERS </qualcosa>
		 * </END_ELEMENT>
		*/
		
		//Ciclo che legge il file fino a raggiungere struttura dell'albero
		while (xMLEventReader.hasNext() && meta){ //il ciclo continua finch� ci sono delle righe e la varabile meta � true
			xMLEvent = xMLEventReader.nextEvent(); // vai alla riga successiva
			switch (xMLEvent.getEventType()){  
			case XMLStreamConstants.START_ELEMENT: // caso <"qualcosa">
				if ((((StartElement) xMLEvent).getName()).getLocalPart().equals("tree")) // quando la parola che leggi � uguale a tree... questo if pu� essere utilizzato per riconoscere se stiamo leggendo il label del nodo o i pesi etc...
					meta = false;
				break;
			}
		}
		
		//Ciclo con la lettura delle informazioni importanti
		while (xMLEventReader.hasNext()){ //il ciclo continua finch� ci sono delle righe
			xMLEvent = xMLEventReader.nextEvent(); // vai alla riga successiva
			switch (xMLEvent.getEventType()){
			case XMLStreamConstants.START_ELEMENT: // sto leggendo <"quello che c'� qui dentro">
				rawXML.append("<"+(((StartElement) xMLEvent).getName()).getLocalPart()+">"); // stampo <"quello che c'� qui dentro">
				break;
			case XMLStreamConstants.CHARACTERS: // sto leggendo <qualcosa> "quello che c'� qui dentro" </qualcosa>
				characters = (Characters) xMLEvent;
				if (!(characters.isWhiteSpace() || characters.isIgnorableWhiteSpace())) rawXML.append(characters.getData()); // stampo <qualcosa> "quello che c'� qui dentro" </qualcosa> 
				break;
			case XMLStreamConstants.END_ELEMENT: // sto leggendo </"quello che c'� qui dentro">
				rawXML.append("</"+(((EndElement) xMLEvent).getName()).getLocalPart()+">"); // stampo </"quello che c'� qui dentro">
				break;
			}
		}	
		return rawXML;
	}

}
