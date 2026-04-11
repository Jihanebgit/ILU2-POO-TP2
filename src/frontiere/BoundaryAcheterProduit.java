package frontiere;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		Boolean acheteurReconnnu = controlAcheterProduit.isHabitant(nomAcheteur);
		if (!acheteurReconnnu) {
			System.out.println("Je suis désolée " + nomAcheteur + " mais il faut être un habitant de notre village "
					+ "pour commercer ici.");
			return;
		}

		String produit = Clavier.entrerChaine("Quel produit voulez-vous acheter ?");

		Boolean produitPresent = controlAcheterProduit.isProduitMarche(produit);

		if (!produitPresent) {
			System.out.println("Désolé, personne ne vend " + "ce produit au marché.");
			return;
			
		} else {

			String[] vendeurs = controlAcheterProduit.rechercherNomsVendeursProduit(produit);
			StringBuilder liste = new StringBuilder("Chez quel commerçant voulez-vous acheter des " + produit + " ?\n");
			for (int i = 0; i < vendeurs.length; i++) {
				liste.append((i + 1) + " - " + vendeurs[i] + "\n");
			}
			int choix = Clavier.entrerEntier(liste.toString());
			while (choix<1 || choix >vendeurs.length){
				choix = Clavier.entrerEntier("Veuillez saisir un choix supérieur à 0 et allant jusqu'à "+vendeurs.length);
			}
			String commercant = vendeurs[choix - 1];

			System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + commercant);
			System.out.println("Bonjour "+nomAcheteur);
			int nbProduit = Clavier.entrerEntier("Combien de " + produit + " voulez-vous acheter ?");
			System.out.println(controlAcheterProduit.acheterProduit(commercant, nomAcheteur, produit, nbProduit));
			
		}

	}
}
