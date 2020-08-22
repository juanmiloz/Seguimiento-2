package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import exceptions.IdentifyCardException;
import exceptions.numberIdentificationException;

class MinimarketTest {
	
	public Minimarket setupStage1(){
		Minimarket newMinimarket = new Minimarket(0);
		return newMinimarket; 
	}
	
	@Test
	void testDataPerson1() {
		boolean comprobation1 = false;
		boolean comprobation2 = false;
		boolean comprobationF = false;
		Minimarket newMinimarket = setupStage1();
		int TD = 2;
		int N = 8723982;
		int dayMonth = 21;
		
		newMinimarket.addDataPerson(TD,N,dayMonth);
		
		if(newMinimarket.getClient().get(0).getTypeDocument().equalsIgnoreCase("C.C.")) {
			comprobation1 = true;
		}
		if(newMinimarket.getClient().get(0).getNumberDocument() == N) {
			comprobation2 = true; 
		}
		if(comprobation1 == true && comprobation2 == true) {
			comprobationF = true;
		}
		assertTrue(comprobationF);
	}
	
	/*Profe en el enunciado del seguimiento decia que 
	 hicieramos las pruebas con el metodo del modelo que agrega
	 a una persona, pero con ese metodo como lo tengo no puedo hacer las pruebas
	 unitarias 2 y 3 debido a que ese metodo no me arroja una excepcion lo hace 
	 otro metodo que esta dentro del primero, entonces no lo lee correctamente.
	 */
	@Test
	void testDataPerson2() {
		boolean comprobation = false;
		String D = "T.I.";
		int N = 123324;
		Client newClient = new Client(D,N);
		
		try {
			newClient.comprobationTypeDocument();
		} catch(IdentifyCardException ice) {
			comprobation = true;
		}
		assertTrue(comprobation);	
	}
	
	@Test
	void testDataPerson3() {
		boolean comprobation = false;
		String D = "C.C.";
		int N = 9823781;
		int dayMonth = 21;
		Client newClient = new Client(D,N);
	
		try {
			newClient.comprobationExitPermit(dayMonth);
		} catch(numberIdentificationException nie) {
			comprobation = true;
		}
		assertTrue(comprobation);	
	}
}
