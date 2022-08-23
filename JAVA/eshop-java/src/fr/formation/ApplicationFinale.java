package fr.formation;

import fr.formation.exception.IdNegativeException;
import fr.formation.exception.ProduitNotFoundException;
import fr.formation.model.Produit;
import fr.formation.service.ProduitService;

public class ApplicationFinale {
	public static void main(String[] args) {
		ProduitService srvProduit = new ProduitService();
		
		// FindAll
		for (Produit p : srvProduit.findAll()) {
			System.out.println(p);
		}
		
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
