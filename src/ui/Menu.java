package ui;
import java.util.Scanner; 
import model.*;
import java.util.InputMismatchException;
import exceptions.IdentifyCardException;
import exceptions.numberIdentificationException;

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
	}
	
	public void newPerson() {
		String typeDocument = "";
		int numberDocument = 0; 
		int numberTypeDocument = 0;
		boolean continuar2 = true;
		Client newClient = new Client("",0); 
		boolean continuar = true;
		boolean enterDocument = false;
		do {
			try {
				System.out.println("\nQue tipo de documento posee?");
				System.out.println("(1)<--- Tarjeta de identidad\n(2)<--- Cedula de ciudadania\n(3)<--- Pasaporte\n(4)<--- Cedula extranjera)");
				numberTypeDocument = in.nextInt();
				if(numberTypeDocument == 1) {
					typeDocument = "T.I.";
					newClient.setTypeDocument(typeDocument);
					newClient.comprobationTypeDocument();
					continuar = false;
				}else if(numberTypeDocument == 2) {
					typeDocument = "C.C.";
					newClient.setTypeDocument(typeDocument);
					newClient.comprobationTypeDocument();
					continuar = false; 
					enterDocument = true;
				}else if(numberTypeDocument == 3) {
					typeDocument = "P.P.";
					newClient.setTypeDocument(typeDocument);
					newClient.comprobationTypeDocument();
					continuar = false; 
					enterDocument = true;
				}else if(numberTypeDocument == 4) {
					typeDocument = "C.E.";
					newClient.setTypeDocument(typeDocument);
					newClient.comprobationTypeDocument();
					continuar = false; 
					enterDocument = true;
				}else {
					System.out.println("Ingrese una de las 4 opciones");
				}				
			}catch(InputMismatchException ime) {
				System.err.println("Ingrese un valor numerico");
				in.nextLine();
			}catch(IdentifyCardException ice) {
				System.err.println("Es menor de edad no puede ingresar al minimercado");
				continuar = false;
			}
		}while(continuar);
		boolean verify = true;
		if (enterDocument){
			do {
				try {
					System.out.println("\nIngrese el numero del documento");
					numberDocument = in.nextInt();
					in.nextLine();
					newClient = new Client(typeDocument, numberDocument);
					newClient.comprobationExitPermit(dayMonth);
					continuar2 = false;
				}catch(InputMismatchException ime) {
					System.err.println("Ingrese un documento valido");
					in.nextLine();
				}catch(numberIdentificationException nce) {
					System.err.println("Usted no tiene permiso de salir hoy");
					continuar2 = false;
					verify = false;
				}
			}while(continuar2);

		}
		
		minimarket.addPerson();
		if(!newClient.getTypeDocument().equalsIgnoreCase("t.i.") && verify) {
			minimarket.addInfoPerson(newClient);
			System.out.println("Sus datos han sido ingresados exitosamente");
		}
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
