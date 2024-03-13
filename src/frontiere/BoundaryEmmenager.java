package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous etes deja un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Etes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					int force = Clavier.entrerEntier("Bienvenue villageois "+ nomVisiteur +"\nQuelle est votre force ?");
					controlEmmenager.ajouterGaulois(nomVisiteur, force);
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		StringBuilder question = new StringBuilder();
		question.append("Bienvenue druide"+ nomVisiteur +"\n"+ "Quel est votre force ?\n"); 
		int forceDruide = Clavier.entrerEntier(question.toString());
		int effetPotMin, effetPotMax ;
		do {
			 effetPotMin = Clavier.entrerEntier("Quelle est la potion la plus faible que vous produisez ?");
			 effetPotMax = Clavier.entrerEntier("Quelle est la potion la plus forte que vous produisez ?");
			 if (effetPotMax<effetPotMin) {
				 System.out.println("Attention druide, vous vous �tes tromp� entre le minimum et le maximum");
			 }
		} while (effetPotMax<effetPotMin);
		
		controlEmmenager.ajouterDruide(nomVisiteur, forceDruide, effetPotMin, effetPotMax);
	}
}
