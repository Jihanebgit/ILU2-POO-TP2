package controleur;

import villagegaulois.Etal;

public class ControlLibererEtal {
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

	public ControlLibererEtal(
			ControlTrouverEtalVendeur controlTrouverEtalVendeur) {
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	//TODO a completer

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
		int quantiteInitial=Integer.valueOf(donneesVentes[3]);
		int quantiteVendu=Integer.valueOf(donneesVentes[4]);
		donneesEtal[0]=etalOccupe.toString();
		donneesEtal[1]=nomVendeur;
		donneesEtal[2]=produit;
		donneesEtal[3]=Integer.toString(quantiteInitial);
		donneesEtal[4]=Integer.toString(quantiteVendu);
		return donneesEtal;
	}

	public boolean isVendeur(String nomVendeur) {
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		return (etal!= null);
	}

}
