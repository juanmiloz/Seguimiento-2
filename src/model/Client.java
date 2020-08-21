package model;
import exceptions.IdentifyCardException;
import exceptions.numberIdentificationException;

public class Client {
	private String typeDocument;
	private int numberDocument;
	
	public Client(String typeDocument, int numberDocument){
		this.typeDocument = typeDocument;
		this.numberDocument = numberDocument;
	}
	
	public void setTypeDocument(String typeDocument) {
		this.typeDocument = typeDocument;
	}
	
	public String getTypeDocument() {
		return typeDocument;
	}
	
	public void setNumberDocument(int numberDocument) {
		this.numberDocument = numberDocument;
	}
	
	public int getNumberDocument() {
		return numberDocument;
	}
	
	public void comprobationTypeDocument() throws IdentifyCardException {
		if(getTypeDocument().equalsIgnoreCase("T.I.")) {
			throw new IdentifyCardException();
		}
	}
	
	public void comprobationExitPermit(int dayMonth) throws numberIdentificationException{
		if(dayMonth%2 == 0 && (getNumberDocument()%10)%2 == 0) {
			throw new numberIdentificationException();
		}else if(dayMonth%2 != 0 && (getNumberDocument()%10)%2 != 0) {
			throw new numberIdentificationException();
		}
		
	}
}
