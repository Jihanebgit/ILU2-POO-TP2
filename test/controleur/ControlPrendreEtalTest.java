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
		village.installerVendeur(abraracourcix, "fleurs", 3);
		assertTrue(controlPrendreEtal.resteEtals());
		Gaulois bonemine= new Gaulois("Bonemine", 2);
		Gaulois racour= new Gaulois("racour",3);
		Gaulois ludo= new Gaulois("Ludo", 2);
		Gaulois fanny= new Gaulois("Fanny",3);
		village.installerVendeur(bonemine, "panier", 3);
		assertTrue(controlPrendreEtal.resteEtals());
		village.installerVendeur(racour, "carton", 3);
		village.installerVendeur(ludo, "nourriture", 3);
		village.installerVendeur(fanny, "cahier", 3);
		assertFalse(controlPrendreEtal.resteEtals());
		
	}

	@Test
	void testPrendreEtal() {
		ControlPrendreEtal controlPrendreEtal=new ControlPrendreEtal(ControlVerifierIdentite, village);
		Gaulois bonemine= new Gaulois("Bonemine", 2);
		assertEquals(0, controlPrendreEtal.prendreEtal("Bonemine", "fleurs", 10));
	}

	@Test
	void testVerifierIdentite() {
		ControlPrendreEtal controlPrendreEtal=new ControlPrendreEtal(ControlVerifierIdentite, village);
		Gaulois bonemine= new Gaulois("Bonemine", 2);
		village.ajouterHabitant(bonemine);
		village.installerVendeur(bonemine, "fleurs", 14);
		assertTrue(controlPrendreEtal.verifierIdentite("Bonemine"));
		assertFalse(controlPrendreEtal.verifierIdentite("nom inconnu"));
		
	}

}
