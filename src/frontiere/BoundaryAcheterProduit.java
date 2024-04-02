package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;

public class BoundaryAcheterProduit {
    private Scanner scan = new Scanner(System.in);
    private ControlAcheterProduit controlAcheterProduit;

    public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
        this.controlAcheterProduit = controlAcheterProduit;
    }

    public void acheterProduit(String nomAcheteur) {
        if (controlAcheterProduit.verifIdentite(nomAcheteur)) {
            System.out.println("Quel produit voulez-vous acheter ?");
            String produit = scan.next();
            Gaulois[] vendeurs = controlAcheterProduit.trouverEtalProduit(produit);
            if (vendeurs != null && vendeurs.length > 0) {
                System.out.println("Chez quel commerçant voulez-vous acheter des " + produit + " ?");
                for (int i = 0; i < vendeurs.length; i++) {
                    System.out.println((i + 1) + " - " + vendeurs[i].getNom());
                }
                int choix = scan.nextInt();
                if (choix > 0 && choix <= vendeurs.length) {
                    String vendeur = vendeurs[choix - 1].getNom();
                    int quantite = 0;
                    System.out.println(vendeurs[choix - 1].getNom() + " se déplace jusqu'à l'étal du vendeur " + vendeur);
                    System.out.println("Bonjour " + vendeurs[choix - 1].getNom());
                    System.out.println("Combien de " + produit + " voulez-vous acheter ?");
                    quantite = scan.nextInt();
                    int nbProduitAcheter = controlAcheterProduit.acheterProduit(vendeur, quantite);
                    if (nbProduitAcheter == 0) {
                        System.out.println(nomAcheteur + " veut acheter " + quantite + " " + produit + ", malheureusement il n'y en a plus !");
                    } else if (nbProduitAcheter < quantite) {
                        System.out.println(nomAcheteur + " veut acheter " + quantite + " " + produit + ", malheureusement " + vendeur + " n'en a plus que " + nbProduitAcheter + ". " + nomAcheteur + " achète tout le stock de " + vendeur + ".");
                    } else {
                        System.out.println(nomAcheteur + " a acheté " + quantite + " " + produit + " à " + vendeur + ".");
                    }
                } else {
                    System.out.println("Choix invalide.");
                }
            } else {
                System.out.println("Désolé, personne ne vend des " + produit + " au marché.");
            }
        } else {
            System.out.println("Je suis désolé " + nomAcheteur + " mais il faut être un habitant de notre village pour commercer ici.");
        }
    }
}
