package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if (controlAcheterProduit.verifIdentite(nomAcheteur)) {
			System.out.println("Quel produit voulez acheter ?");
			String produit = scan.next(); 
			System.out.println(controlAcheterProduit.afficherVendeur(controlAcheterProduit.trouverEtalProduit(produit)));
		}
	}
}
