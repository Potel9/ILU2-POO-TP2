package controleur;

import villagegaulois.Village;

public class ControlVerifierIdentite {
	private Village village;

	public ControlVerifierIdentite(Village village) {
		this.village = village;
	}

	public boolean verifierIdentite(String nomVendeur) {
		if (village.trouverHabitant(nomVendeur)!=null) {
			return true ;
		}
		else {
			return false ;
		}
	}
}
