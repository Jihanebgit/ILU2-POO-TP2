package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	private Village village = new Village("village", 0, 0);
	private Chef abraracourcix;
	private ControlVerifierIdentite ControlVerifierIdentite = new ControlVerifierIdentite(village);
	private ControlPrendreEtal controlPrendreEtal=new ControlPrendreEtal(ControlVerifierIdentite, village);
	
	@BeforeEach
	void initialiserSituation() {
		System.out.println("Initilisation...");
		village= new Village("le village des irréductibles",10,5);
		abraracourcix= new Chef("Abraracourcix",10,village);
		village.setChef(abraracourcix);
		ControlVerifierIdentite=new ControlVerifierIdentite(village);
	}
	@Test
	void testControlPrendreEtal() {
		ControlPrendreEtal controlPrendreEtal=new ControlPrendreEtal(ControlVerifierIdentite, village);
		assertNotNull(controlPrendreEtal,"le controleur ne renvoie pas null");
	}

	@Test
	void testResteEtals() {
		ControlPrendreEtal controlPrendreEtal=new ControlPrendreEtal(ControlVerifierIdentite, village);
	}

	@Test
	void testPrendreEtal() {
		fail("Not yet implemented");
	}

	@Test
	void testVerifierIdentite() {
		fail("Not yet implemented");
	}

}
