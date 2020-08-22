package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import exceptions.IdentifyCardException;
import exceptions.numberIdentificationException;
import exceptions.OptionNoValidException;

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
		
		try {
			newMinimarket.addDataPerson(TD,N,dayMonth);
		} catch(IdentifyCardException ice) {
		 	System.out.println("1");
		} catch(OptionNoValidException ove) {
			System.out.println("2");
		} catch(numberIdentificationException nie) {
			System.out.println("3");
		}
		
		
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
	
	@Test
	void testDataPerson2() {
		Minimarket newMinimarket = setupStage1();
		boolean comprobation = false;
		int D = 1;
		int N = 123324;
		int dayMonth = 21;
		
		try {
			newMinimarket.addDataPerson(D, N, dayMonth);
		} catch(IdentifyCardException ice) {
			comprobation = true;
		} catch(OptionNoValidException ove) {
			comprobation = false;
		} catch(numberIdentificationException nie) {
			comprobation = false; 
		}
		assertTrue(comprobation);	
	}
	
	@Test
	void testDataPerson3() {
		boolean comprobation = false;
		Minimarket newMinimarket = setupStage1();
		int D = 2;
		int N = 9823781;
		int dayMonth = 21;
	
		try {
			newMinimarket.addDataPerson(D, N, dayMonth);
		} catch(numberIdentificationException nie) {
			comprobation = true;
		} catch(OptionNoValidException ove) {
			comprobation = false;
		} catch(IdentifyCardException ice) {
			comprobation = false;
		}
		assertTrue(comprobation);	
	}
}
