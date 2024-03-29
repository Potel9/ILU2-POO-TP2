package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.*;
import villagegaulois.*;

class ControlAfficherVillageTest {

	
	private Village village ;
	private Chef abraracourcix ;
	
	
	
	@BeforeEach
	void setUp() {
		System.out.println("Initialisation.....");
		village = new Village("Le village des irréductibles", 10,5);
		abraracourcix = new Chef ("Abraracourcix", 10 , village);
		village.setChef(abraracourcix);
	}
	
	
	
	
	
	@Test
	void testControlAfficherVillage() {
		ControlAfficherVillage control = new ControlAfficherVillage(village);
		assertNotNull(control, "le controller ne renvois pas null");	
	}

	@Test
	void testDonnerNomsVillageois() {
		ControlAfficherVillage control = new ControlAfficherVillage(village);
		assert(control.donnerNomsVillageois()!= null);
	}

	@Test
	void testDonnerNomVillage() {
		ControlAfficherVillage control = new ControlAfficherVillage(village);
		assert(control.donnerNomVillage().equals(village.getNom()));
	}

	@Test
	void testDonnerNbEtals() {
		ControlAfficherVillage control = new ControlAfficherVillage(village);
		assert(control.donnerNbEtals()==village.donnerNbEtal());
	}

}
