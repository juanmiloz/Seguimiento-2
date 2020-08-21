package model;
import java.util.ArrayList;

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
	
	public void addPerson() {
		int newPerson = 1;
		newPerson += getNumberPersons();
		
		setNumberPersons(newPerson);
	}
	
	public void addInfoPerson(Client newClient) {
		peapleEntry.add(newClient);
	}
}
