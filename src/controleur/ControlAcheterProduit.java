package controleur;

import frontiere.Clavier;
import personnages.Gaulois;
import villagegaulois.Etal;
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
    public Etal trouverEtalVendeurs(String vendeur ) {
    	return village.rechercherEtal(village.trouverHabitant(vendeur));
    	
    	
    }
    
    public int acheterProduit(String vendeur, int quantite) {
            Etal vendeurs = trouverEtalVendeurs(vendeur);int achat = 0;
            if (vendeurs != null ) {
            	 achat = vendeurs.acheterProduit(quantite);
            } else {
                System.out.println("Aucun vendeur trouvé pour ce produit.");
                
            }
        return achat ;
        
    }

}