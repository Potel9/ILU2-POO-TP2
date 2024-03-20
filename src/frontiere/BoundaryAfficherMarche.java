package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infos = controlAfficherMarche.donnerInfosMarche();
		if(infos.length == 0 ) {
			System.out.println("Le marché est vide, revenez plus tard.");
		}
		else {
			System.out.println(nomAcheteur + " vous trouverez au marché :");
			for (int i = 0 ; i < infos.length;i++) {
				String vendeur = infos[i];
				i++;
				String quantite = infos[i];
				i++;
				String produit = infos[i];
				i++;
				System.out.println("-"+ vendeur+" qui vend " + quantite+" "+produit );
			}
		}
	}
}
