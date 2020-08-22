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
	
	public boolean addDataPerson(int numberTypeDocument, int numberDocument, int dayMonth) {
		String typeDocument = "";
		Client newClient;
		boolean repeat = false;
		boolean addInfo = true;
		
		try {
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
		}catch(IdentifyCardException ice) {
			System.err.println("Es menor de edad no puede ingresar al minimercado");
			addInfo = false;
		}catch(OptionNoValidException ove) {
			System.err.println("Ingrese una opcion valida");
			addInfo = false;
			repeat = true;
		}catch(numberIdentificationException nce) {
			System.err.println("Usted no tiene permiso de salir hoy");
			addInfo = false;
		}
		
		newClient = new Client(typeDocument, numberDocument);
		if(addInfo) {
			addInfoPerson(newClient);
			System.out.println("\nSi puede ingresar al local\nSus datos seran almacenados por motivos de seguridad");
		}
		
		return repeat;
	}
}
