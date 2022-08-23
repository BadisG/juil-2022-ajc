package fr.formation;

import fr.formation.model.Fournisseur;
import fr.formation.service.FournisseurService;

public class ApplicationFinale {
	public static void main(String[] args) {
		FournisseurService srvFournisseur = new FournisseurService();
		
		for (Fournisseur f : srvFournisseur.findAll()) {
			System.out.println(f.getNom());
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
