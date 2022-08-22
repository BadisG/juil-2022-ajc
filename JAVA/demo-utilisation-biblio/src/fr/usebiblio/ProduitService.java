package fr.usebiblio;

import java.util.ArrayList;
import java.util.List;

import fr.formation.model.Produit;
import fr.formation.repo.IProduitRepository;
import fr.formation.repo.sql.ProduitRepositorySql;

public class ProduitService {
	public List<Produit> findAll() {
		IProduitRepository repoProduit = new ProduitRepositorySql();
		
//		return repoProduit.findAll();
		
		List<Produit> produits = repoProduit.findAll();
		
		if (produits == null) {
			return new ArrayList<>();
		}
		
		return produits;
	}
}
