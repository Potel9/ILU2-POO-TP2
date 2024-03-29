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
    void testControlLibererEtal() {
        // Test de la création du contrôleur de libération d'étal
        ControlLibererEtal control = new ControlLibererEtal(controlVendeur);
        assertNotNull(control, "Le contrôleur n'est pas null");
    }

    @Test
    void testLibererEtal() {
        // Test de la libération de l'étal
        ControlLibererEtal control = new ControlLibererEtal(controlVendeur);
        String[] expectedEtalState = controlVendeur.trouverEtalVendeur("Obelix").etatEtal();
        assertArrayEquals(expectedEtalState, control.libererEtal("Obelix"), "L'état de l'étal correspond");
    }

    @Test
    void testIsVendeur() {
        // Test si un personnage est un vendeur
        ControlLibererEtal control = new ControlLibererEtal(controlVendeur);
        assertTrue(control.isVendeur("Obelix"), "Obelix est un vendeur");
        assertFalse(control.isVendeur("Nonexistent"), "Le personnage inexistant n'est pas un vendeur");
    }
}
