package fr.formation;

import fr.formation.exception.FournisseurNotFoundException;
import fr.formation.exception.IdNegativeException;
import fr.formation.model.Fournisseur;
import fr.formation.service.FournisseurService;

public class ApplicationFinale {
	public static void main(String[] args) {
		FournisseurService srvFournisseur = new FournisseurService();
		
		try {
			srvFournisseur.deleteById(4);
		}

		catch (IdNegativeException e) {
			System.out.println("L'id est pas bon.");
		}
		
		
//		Fournisseur monNouveauFournisseur = new Fournisseur();
//		monNouveauFournisseur.setNom("From JAVA");
//		monNouveauFournisseur.setResponsable("Je suis le responsable ici");
//		
//		srvFournisseur.save(monNouveauFournisseur);
		
		
		try {
			Fournisseur leFournisseurAModifier = srvFournisseur.findById(2);
			leFournisseurAModifier.setNom("NEW NOM FROM JAVA");
			srvFournisseur.save(leFournisseurAModifier);
		}

		catch (IdNegativeException e) {
			System.out.println("Id incorrect.");
		}

		catch (FournisseurNotFoundException e) {
			System.out.println("Fournisseur non trouvé.");
		}
		
		
		for (Fournisseur f : srvFournisseur.findAll()) {
			System.out.println(f.getId() + " " + f.getNom());
		}
		
		
		
//		ProduitService srvProduit = new ProduitService();
//		
//		// FindAll
//		for (Produit p : srvProduit.findAll()) {
//			System.out.println(p);
//		}
		
		// FindById
//		try {
//			Produit produit = srvProduit.findById(2);
//			System.out.println(produit);
//		}
//
//		catch (ProduitNotFoundException e) {
//			System.out.println("Produit non trouvé.");
//		}
//
//		catch (IdNegativeException e) {
//			System.out.println("ID pas bon.");
//		}
	}

}
