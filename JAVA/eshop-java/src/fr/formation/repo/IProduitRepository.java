package fr.formation.repo;

import fr.formation.model.Produit;

public interface IProduitRepository extends IRepository<Produit, Integer> {
	// Ici, on mettra les méthodes spécifiques au CRUD "Produit"
	
	// Exemple : chercher un produit par son nom
	public Produit findByNom(String nom);
}
