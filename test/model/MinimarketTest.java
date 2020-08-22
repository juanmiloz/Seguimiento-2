package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MinimarketTest {
	
	public Minimarket setupStage1(){
		Minimarket newMinimarket = new Minimarket(0);
		return newMinimarket; 
	}
	
	public Minimarket setupStage2() {
		Minimarket newMinimarket = new Minimarket(2);
		String D = "C.C."; 
		int N = 2987432;
		Client newClient = new Client(D, N);
		D = "P.P.";
		N = 3729878;
		newClient = new Client(D,N);
		return newMinimarket;
	}
	
	@Test
	void dataPerson() {
		boolean comprobation1 = false;
		boolean comprobation2 = false;
		Minimarket newMinimarket = setupStage1();
		int TD = 2;
		int N = 8723982;
		int dayMonth = 21;
		newMinimarket.dataPerson(TD,N,dayMonth);
		
	}

}
