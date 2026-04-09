package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlLibererEtalTest {
	private Village village;
	private Chef abraracourcix;
	@BeforeEach
	
	public void initialiserSituation() {
		System.out.println("Initilisation...");
		village= new Village("le village des irréductibles",10,5);
		abraracourcix= new Chef("Abraracourcix",10,village);
		village.setChef(abraracourcix);
	}
	
	@Test
	void testControlLibererEtal() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(null);
		fail("Not yet implemented");
	}

	@Test
	void testLibererEtal() {
		fail("Not yet implemented");
	}
	
}
