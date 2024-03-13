package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		
		if( controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("Bonjour "+nomVendeur+" je vais regarder si je peux vous trouver un etal.");
			installerVendeur(nomVendeur);
			}
		else {
			System.out.println("Je suis Désolée "+ nomVendeur + " mais il faut être un habitant de notre village pour commencer ici." );
		}
		
	}

	private void installerVendeur(String nomVendeur) {
		int etal = -1;
		StringBuilder question = new StringBuilder();
		question.append("C'est parfait, il me reste un étal pour vous !\nil me faudrait quelques renseignements :\nQuel produit souhaitez vous vendre ?");
		String produit = Clavier.entrerClavier(question.toString());
		int nbProduit = Clavier.entrerEntier("Combien souhaitez vous en	 vendre ?");
		etal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if (etal!=-1) {
			etal+=1;
			System.out.println("Le vendeur "+ nomVendeur+" s'est installé à l'étal n°"+etal);
		}
	}
}
