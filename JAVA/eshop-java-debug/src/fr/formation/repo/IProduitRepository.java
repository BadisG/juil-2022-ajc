package fr.formation.repo;

import java.util.Optional;

import fr.formation.model.Produit;

public interface IProduitRepository extends IRepository<Produit, Integer> {
	public Optional<Produit> findByNom(String nom);
}
