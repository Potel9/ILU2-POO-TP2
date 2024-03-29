package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

class ControlLibererEtalTest {
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
    void testControlLibererEtal() {
        // Test de la cr�ation du contr�leur de lib�ration d'�tal
        ControlLibererEtal control = new ControlLibererEtal(controlVendeur);
        assertNotNull(control, "Le contr�leur n'est pas null");
    }

    @Test
    void testLibererEtal() {
        // Test de la lib�ration de l'�tal
        ControlLibererEtal control = new ControlLibererEtal(controlVendeur);
        String[] expectedEtalState = controlVendeur.trouverEtalVendeur("Obelix").etatEtal();
        assertArrayEquals(expectedEtalState, control.libererEtal("Obelix"), "L'�tat de l'�tal correspond");
    }

    @Test
    void testIsVendeur() {
        // Test si un personnage est un vendeur
        ControlLibererEtal control = new ControlLibererEtal(controlVendeur);
        assertTrue(control.isVendeur("Obelix"), "Obelix est un vendeur");
        assertFalse(control.isVendeur("Nonexistent"), "Le personnage inexistant n'est pas un vendeur");
    }
}
