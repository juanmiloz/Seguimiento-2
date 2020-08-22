package model;
import java.util.ArrayList;
import java.util.List;
import exceptions.IdentifyCardException;
import exceptions.numberIdentificationException;
import exceptions.OptionNoValidException;

public class Minimarket {
	private int numberPersons;
	private ArrayList<Client> peapleEntry;
	
	public Minimarket(int numberPersons) {
		this.numberPersons = numberPersons;
		peapleEntry = new ArrayList<Client>();
	}
	
	public void setNumberPersons(int numberPersons) {
		this.numberPersons = numberPersons;
	}
	
	public int getNumberPersons() {
		return numberPersons; 
	}
	
	public List<Client> getClient(){
		return peapleEntry;
	} 
	
	public void addPerson() {
		int newPerson = 1;
		newPerson += getNumberPersons();
		
		setNumberPersons(newPerson);
	}
	
	public void addInfoPerson(Client newClient) {
		peapleEntry.add(newClient);
	}
	
	public void comprobationOptionValid(int numberTypeDocument) throws OptionNoValidException {
		if(numberTypeDocument<1 || numberTypeDocument > 4) {
			throw new OptionNoValidException();
		}
	}
	
	public String addDataPerson(int numberTypeDocument, int numberDocument, int dayMonth)throws IdentifyCardException, numberIdentificationException, OptionNoValidException{
		String typeDocument = "";
		Client newClient;
		
	
		if(numberTypeDocument == 1) {
			typeDocument = "T.I.";
			newClient = new Client(typeDocument, numberDocument);
			newClient.comprobationTypeDocument();
		}else if(numberTypeDocument == 2) {
			typeDocument = "C.C.";
		}else if(numberTypeDocument == 3) {
			typeDocument = "P.P.";
		}else if(numberTypeDocument == 4) {
			typeDocument = "C.E.";
		}else {
			comprobationOptionValid(numberTypeDocument);
		}
		newClient = new Client(typeDocument, numberDocument);
		newClient.comprobationExitPermit(dayMonth);
		
		
		
		return typeDocument;
	}
}
