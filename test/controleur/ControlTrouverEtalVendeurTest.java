package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {
	
    private Village village;
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
    void testControlTrouverEtalVendeur() {
        assertNotNull(controlVendeur, "Le contrôleur n'est pas null");
    }

    @Test
    void testTrouverEtalVendeur() {
        // Test si l'étal d'un vendeur est correctement trouvé
        Etal etalObelix = controlVendeur.trouverEtalVendeur("Obelix");
        assertNotNull(etalObelix, "L'étal d'Obelix n'est pas null");
        assertEquals("Obelix", etalObelix.getVendeur().getNom(), "Le vendeur de l'étal est Obelix");
    }
}
