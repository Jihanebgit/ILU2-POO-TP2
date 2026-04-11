package controleur;

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

	// verif de la presence du produit 
	public Boolean isProduitMarche(String produit) {
		String[] donnnesMarche= village.donnerEtatMarche();
		for (int i=2; i<donnnesMarche.length; i+=3) {
			if (donnnesMarche[i].equals(produit)) {
				return true;
			}
		}
		return false;
	}
	
	//verif que c'est bien un habitant 
	public Boolean isHabitant(String nom) {
		return controlVerifierIdentite.verifierIdentite(nom);
	}
	
	//rechercher les vendeurs d'un produit 
	public String[] rechercherNomsVendeursProduit(String produit) {
	    Gaulois[] vendeurs = village.rechercherVendeursProduit(produit);
	    String[] noms = new String[vendeurs.length];
	    for (int i = 0; i < vendeurs.length; i++) {
	        noms[i] = vendeurs[i].getNom();
	    }
	    return noms;
	}
	
	
	//trouve l'etal du vendeur 
	public Etal trouverEtalVendeur(String nomVendeur) {
		return controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
	}
	
	//donne la quantite disponible 
	public int quantiteProduit(Etal etal) {
		return etal.getQuantite();
	}
	
	public String acheterProduit(String nomVendeur, String nomAcheteur, String produit, int nbProduit) {
	    Etal etal = trouverEtalVendeur(nomVendeur);
	    int quantiteDispo = etal.getQuantite();
	    
	    if (quantiteDispo == 0) {
	        return nomAcheteur + " veut acheter " + nbProduit + " "
	            + produit + ", malheureusement il n'y en a plus !";
	    } else if (quantiteDispo < nbProduit) {
	        etal.acheterProduit(quantiteDispo);
	        return nomAcheteur + " veut acheter " + nbProduit + " "
	            + produit + ", malheureusement " + nomVendeur + " n'en a plus que "
	            + quantiteDispo + ". " + nomAcheteur + " achète tout le stock de " + nomVendeur + ".";
	    } else {
	        etal.acheterProduit(nbProduit);
	        return nomAcheteur + " achète " + nbProduit + " " + produit + " à " + nomVendeur + ".";
	    }
	}
	
	
}
