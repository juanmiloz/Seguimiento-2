package ui;
import java.util.Scanner;

import exceptions.IdentifyCardException;
import exceptions.OptionNoValidException;
import exceptions.numberIdentificationException;
import model.*;
import java.util.InputMismatchException;

public class Menu {
	private Scanner in = new Scanner(System.in);
	private final static int NEW_PERSON = 1;
	private final static int CONSULT_NUMBER_PERSON = 2;
	private final static int EXIT = 3;
	private boolean salir = true;
	private int dayMonth;
	private Minimarket minimarket = new Minimarket(0);
	
	public void dayMonth() {
		System.out.println("Ingrese el dia del mes");
		dayMonth = in.nextInt();
	}
	
	public void menu() {
		int option; 
		
		try {
			System.out.println("\nBienvenido al Minimercado Mi Barrio Te Quiere");
			System.out.println("Menu de opciones");
			System.out.println("(1)<--- Ingresar una nueva persona");
			System.out.println("(2)<--- Consultar cantidad de personas que han intentado ingresar");
			System.out.println("(3)<--- Salir del programa");
			option = in.nextInt();
				
			switch(option){
					
				case NEW_PERSON:
					 newPerson();
				break;
					
				case CONSULT_NUMBER_PERSON:
					consultNumberPerson();
				break;
					
				case EXIT:
					exit();
				break;
			}
		}catch(InputMismatchException ime) {
			System.err.println("Ingrese datos numericos porfavor");
			in.nextLine();
		}
	}
	
	public void newPerson() {
		int typeDocument;
		int numberTypeDocument = 0;
		boolean continuar = false;
		boolean addInfo = true;
		String nameDocument = null;
		
		minimarket.addPerson();
		
		do {
			try {
				System.out.println("\nQue tipo de documento posee?");
				System.out.println("(1)<--- Tarjeta de identidad\n(2)<--- Cedula de ciudadania\n(3)<--- Pasaporte\n(4)<--- Cedula extranjera)");
				typeDocument = in.nextInt();
				
				System.out.println("\nIngrese el numero del documento");
				numberTypeDocument = in.nextInt();
				
				nameDocument = minimarket.addDataPerson(typeDocument, numberTypeDocument, dayMonth);

			}catch(InputMismatchException ime) {
				System.err.println("Ingrese valores validos");
				continuar = true;
				in.nextLine();
			}catch(IdentifyCardException ice) {
				System.err.println("Es menor de edad no puede ingresar al minimercado");
				addInfo = false;
			}catch(OptionNoValidException ove) {
				System.err.println("Ingrese una opcion valida");
				addInfo = false;
			}catch(numberIdentificationException nce) {
				System.err.println("Usted no tiene permiso de salir hoy");
				addInfo = false;
			}
			
			Client newClient = new Client(nameDocument,numberTypeDocument);
			
			if(addInfo) {
				minimarket.addInfoPerson(newClient);
				System.out.println("\nSi puede ingresar al local\nSus datos seran almacenados por seguridad");
			}
		}while(continuar);
	}
	
	public void consultNumberPerson() {
		System.out.println("El numero de personas que han intentado ingresar son: " + minimarket.getNumberPersons());
	}
	
	public void exit() {
		salir = false;
	} 
	
	public void startProgram() {
		dayMonth();
		while(salir) {
			menu();
		}
	}
}
