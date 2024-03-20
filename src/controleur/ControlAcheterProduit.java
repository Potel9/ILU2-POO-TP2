package controleur;

import personnages.Gaulois;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean verifIdentite(String nom) {
		return controlVerifierIdentite.verifierIdentite(nom);
	}

	public Gaulois[] trouverEtalProduit(String produit) {
			return village.rechercherVendeursProduit(produit);
	}
	public StringBuilder afficherVendeur(Gaulois[] listeVendeur) {
		StringBuilder chaine = new StringBuilder();
		for (int i = 0 ; i<listeVendeur.length;i++) {
			chaine.append(i +"- "+listeVendeur[i].getNom()+"\n");
		}
		return chaine ;
	}
}
