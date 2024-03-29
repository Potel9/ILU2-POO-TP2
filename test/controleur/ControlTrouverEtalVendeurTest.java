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
        village = new Village("le village des irr�ductibles", 10, 5);
        // Cr�ation du chef du village
        abraracourcix = new Chef("Abraracourcix", 10, village);
        village.setChef(abraracourcix);
        // Cr�ation de deux Gaulois
        Gaulois asterix = new Gaulois("Asterix", 6);
        Gaulois obelix = new Gaulois("Obelix", 12);
        // Ajout des personnages au village
        ControlEmmenager controlEmmenager = new ControlEmmenager(village);
        controlEmmenager.ajouterDruide("Panoramix", 10, 5, 7);
        controlEmmenager.ajouterGaulois("Asterix", 6);
        controlEmmenager.ajouterGaulois("Obelix", 12);
        // Contr�le pour prendre un �tal
        ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
        ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
        int numeroEtal = controlPrendreEtal.prendreEtal("Obelix", "fleur", 5);
        // Initialisation du contr�leur pour trouver un �tal vendeur
        controlVendeur = new ControlTrouverEtalVendeur(village);
    }

    @Test
    void testControlTrouverEtalVendeur() {
        assertNotNull(controlVendeur, "Le contr�leur n'est pas null");
    }

    @Test
    void testTrouverEtalVendeur() {
        // Test si l'�tal d'un vendeur est correctement trouv�
        Etal etalObelix = controlVendeur.trouverEtalVendeur("Obelix");
        assertNotNull(etalObelix, "L'�tal d'Obelix n'est pas null");
        assertEquals("Obelix", etalObelix.getVendeur().getNom(), "Le vendeur de l'�tal est Obelix");
    }
}
