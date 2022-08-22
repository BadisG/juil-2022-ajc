package fr.usebiblio;

import fr.formation.model.Produit;
import fr.formation.repo.IProduitRepository;
import fr.formation.repo.sql.ProduitRepositorySql;

public class Application {
	public static void main(String[] args) {
		ProduitService srvProduit = new ProduitService();
		
		System.out.println("PARCOURS DE LA LISTE");
		
//		try {
//			for (Produit p : srvProduit.findAll()) {
//				System.out.println(p.getNom());
//			}
//		}
//		
//		catch (NullPointerException e) {
//			System.out.println("Attention, liste vide !");
//		}

		for (Produit p : srvProduit.findAll()) {
			System.out.println(p.getNom());
		}
		
		System.out.println("FIN");
	}
}
