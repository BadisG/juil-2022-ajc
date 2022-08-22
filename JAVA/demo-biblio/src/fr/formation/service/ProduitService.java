package fr.formation.service;

import fr.formation.exception.IdNegativeException;
import fr.formation.exception.ProduitNotFoundException;
import fr.formation.model.Produit;
import fr.formation.repo.IProduitRepository;
import fr.formation.repo.sql.ProduitRepositorySql;

public class ProduitService {
	public Produit findById(int id) throws IdNegativeException {
		IProduitRepository repoProduit = new ProduitRepositorySql();
		
		// Vérification de l'id
		if (id <= 0) {
			throw new IdNegativeException(); // Si on arrive ici, la méthode s'arrête (comme un return)
		}
		
		// Vérification du produit
		Produit leProduit = repoProduit.findById(id);
		
		if (leProduit == null) {
			throw new ProduitNotFoundException(); // Si on arrive ici, la méthode s'arrête (comme un return)
		}
		
		// On retourne le produit trouvé
		return leProduit;
	}
}
