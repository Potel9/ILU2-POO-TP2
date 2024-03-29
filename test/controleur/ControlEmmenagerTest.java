/**
 * 
 */
package controleur;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.*;
import villagegaulois.*;


/**
 * @author SLM4228A
 *
 */
class ControlEmmenagerTest {
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
	void testControlEmmenager() {
		ControlEmmenager control = new ControlEmmenager(village);
		assertNotNull(control, "le controller ne renvois pas null");	
	}

	/**
	 * Test method for {@link controleur.ControlEmmenager#isHabitant(java.lang.String)}.
	 */
	@Test
	void IsHabitant() {
		ControlEmmenager control = new ControlEmmenager(village);
		control.ajouterGaulois("Bonnemine", 10); 
		assertTrue(control.isHabitant("Bonnemine"));
		assertFalse(control.isHabitant("N'existe pas"));
		control.ajouterDruide("Panoramix", 8, 2, 12);
		assertTrue(control.isHabitant("Panoramix"));
	}

	/**
	 * Test method for {@link controleur.ControlEmmenager#ajouterDruide(java.lang.String, int, int, int)}.
	 */
	@Test
	void testAjouterDruide() {
		ControlEmmenager control = new ControlEmmenager(village);
		control.ajouterDruide("Panoramix", 8, 2, 12);
		assertTrue(control.isHabitant("Panoramix"));
		assertFalse(control.isHabitant("N'existe pas"));
	}

	/**
	 * Test method for {@link controleur.ControlEmmenager#ajouterGaulois(java.lang.String, int)}.
	 */
	@Test
	void testAjouterGaulois() {
		ControlEmmenager control = new ControlEmmenager(village);
		control.ajouterGaulois("Bonnemine", 10); 
		assertTrue(control.isHabitant("Bonnemine"));
		assertFalse(control.isHabitant("N'existe pas"));
	}

}
