package controleur;

import villagegaulois.Etal;

public class ControlLibererEtal {
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

	public ControlLibererEtal(
			ControlTrouverEtalVendeur controlTrouverEtalVendeur) {
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}


	/**
	 * 
	 * @param nomVendeur
	 * @return donneesEtal est un tableau de chaine contenant
	 * 		[0] : un boolean indiquant si l'étal est occupé
	 * 		[1] : nom du vendeur
	 * 		[2] : produit vendu
	 * 		[3] : quantité de produit à vendre au début du marché
	 * 		[4] : quantité de produit vendu
	 */
	public String[] libererEtal(String nomVendeur) {
		String[] donneesEtal= new String[5];
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		Boolean etalOccupe=etal.isEtalOccupe();
		String[] donneesVentes=etal.etatEtal();
		String produit= donneesVentes[2];
		int quantiteInitial=Integer.parseInt(donneesVentes[3]);
		int quantiteVendu=Integer.parseInt(donneesVentes[4]);
		
		donneesEtal[0]=etalOccupe.toString();	//boolean en string de vide ou non 
		donneesEtal[1]=nomVendeur;	// nom du vendeur 
		donneesEtal[2]=produit;	// nom du produit 
		donneesEtal[3]=Integer.toString(quantiteInitial);	// quantite au debut 
		donneesEtal[4]=Integer.toString(quantiteVendu);	// quantite vendu après
		return donneesEtal; //un tableau avec les donnees de l'etal 
	}

	public boolean isVendeur(String nomVendeur) {
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		return (etal!= null);
	}

}
