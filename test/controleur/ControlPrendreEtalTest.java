package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {

    private Village village;
    private ControlVerifierIdentite controlVerifierIdentite;
    private ControlPrendreEtal controlPrendreEtal;
    private Chef abraracourcix;
    private ControlTrouverEtalVendeur controlVendeur;

    @BeforeEach
    void setUp() {
        System.out.println("Initialisation.....");
        // Initialisation du village
        village = new Village("le village des irréductibles", 10, 5);
        // Création du chef du village
        abraracourcix = new Chef("Abraracourcix", 10, village);
        village.setChef(abraracourcix);
        // Création de deux Gaulois
        Gaulois asterix = new Gaulois("Asterix", 6);
        Gaulois obelix = new Gaulois("Obelix", 12);
        // Ajout des personnages au village
        ControlEmmenager controlEmmenager = new ControlEmmenager(village);
        controlEmmenager.ajouterDruide("Panoramix", 10, 5, 7);
        controlEmmenager.ajouterGaulois("Asterix", 6);
        controlEmmenager.ajouterGaulois("Obelix", 12);
        // Contrôle pour prendre un étal
        ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
        ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
        int numeroEtal = controlPrendreEtal.prendreEtal("Obelix", "fleur", 5);
        // Initialisation du contrôleur pour trouver un étal vendeur
        controlVendeur = new ControlTrouverEtalVendeur(village);
    }
    @Test
    void testControlPrendreEtal() {
    	ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
        assertNotNull(controlPrendreEtal, "Le contrôleur n'est pas null");
    }

    @Test
    void testResteEtals() {
        // Test pour vérifier s'il reste des étals vides dans le village
    	ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
        assertTrue(controlPrendreEtal.resteEtals(), "Il reste des étals vides dans le village");
    }

    @Test
    void testPrendreEtal() {
        // Test pour prendre un étal avec un vendeur existant
    	ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
        int numeroEtal = controlPrendreEtal.prendreEtal("Panoramix", "potion", 10);
        assertTrue(numeroEtal >= 0, "L'étal a été pris avec succès");

        // Test pour prendre un étal avec un vendeur inexistant
        int numeroEtalInexistant = controlPrendreEtal.prendreEtal("Asterix", "fleur", 5);
        assertEquals(-1, numeroEtalInexistant, "L'étal n'a pas été pris car le vendeur est inexistant");
    }

    @Test
    void testVerifierIdentite() {
    	ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
        // Test de vérification d'identité avec un habitant existant
        assertTrue(controlPrendreEtal.verifierIdentite("Panoramix"), "Panoramix existe dans le village");

        // Test de vérification d'identité avec un habitant inexistant
        assertFalse(controlPrendreEtal.verifierIdentite("Astérix"), "Astérix n'existe pas dans le village");
    }
}

