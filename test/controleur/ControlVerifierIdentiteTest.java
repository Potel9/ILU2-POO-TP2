package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {

    private Village village;
    private ControlVerifierIdentite controlVerifierIdentite;

    @BeforeEach
    void setUp() {
        System.out.println("Initialisation.....");
        // Initialisation du village
        village = new Village("le village des irréductibles", 10, 5);
        // Initialisation du contrôleur pour vérifier l'identité
        controlVerifierIdentite = new ControlVerifierIdentite(village);
        ControlEmmenager controlEmmenager = new ControlEmmenager(village);
        controlEmmenager.ajouterDruide("Panoramix", 10, 5, 7);
    }

    @Test
    void testControlVerifierIdentite() {
        assertNotNull(controlVerifierIdentite, "Le contrôleur n'est pas null");
    }

    @Test
    void testVerifierIdentite() {
        // Test de vérification d'identité avec un habitant existant
        assertTrue(controlVerifierIdentite.verifierIdentite("Panoramix"), "Panoramix existe dans le village");
        
        // Test de vérification d'identité avec un habitant inexistant
        assertFalse(controlVerifierIdentite.verifierIdentite("Astérix"), "Astérix n'existe pas dans le village");
    }
}
