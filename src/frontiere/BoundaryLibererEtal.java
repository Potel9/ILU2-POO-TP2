package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		if (controlLibererEtal.isVendeur(nomVendeur) == false) {
			System.out.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui !");
		}
		else {
			String[] donnees =  controlLibererEtal.libererEtal(nomVendeur);
	           if (donnees != null) {
	                String produit = donnees[2];
	                String quantiteInitial = donnees[3];
	                String quantiteVendu = donnees[4];
			
			
	                System.out.println("Vous avez vendu "+ quantiteVendu + "sur "+ quantiteInitial +" "+ produit+".\nAu revoir "+nomVendeur+", passez une bonne journée.");
			
		}}	
	}
	

}
