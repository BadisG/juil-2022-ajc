package fr.formation.service;

import java.util.ArrayList;
import java.util.List;

import fr.formation.exception.EntityNotValidException;
import fr.formation.exception.InvalidArgsException;
import fr.formation.exception.ProduitNotFoundException;
import fr.formation.model.Produit;
import fr.formation.repo.IProduitRepository;
import fr.formation.repo.sql.ProduitRepositorySql;

public class ProduitService {
	private IProduitRepository repoProduit = new ProduitRepositorySql();
	
	public Produit findById(int id) {
		// Vérification de l'id
		if (id <= 0) {
			throw new InvalidArgsException(); // Si on arrive ici, la méthode s'arrête (comme un return)
		}
		
		// Vérification du produit
		Produit produit = this.repoProduit.findById(id);
		
		if (produit == null) {
			throw new ProduitNotFoundException(); // Si on arrive ici, la méthode s'arrête (comme un return)
		}
		
		// On retourne le produit trouvé
		return produit;
	}
	
	public Produit findByNom(String nom) {
		if (nom == null || nom.isBlank()) {
			throw new InvalidArgsException();
		}
		
		return this.repoProduit.findByNom(nom).orElseThrow(ProduitNotFoundException::new);
	}
	
	public List<Produit> findAll() {
		List<Produit> produits = this.repoProduit.findAll();

		if (produits == null) {
			return new ArrayList<>();
		}
		
		return produits;
	}
	
	public void save(Produit produit) {
		if (produit == null) {
			throw new InvalidArgsException();
		}
		
		if (produit.getNom() == null || produit.getNom().isBlank()) {
			throw new EntityNotValidException();
		}
		
		if (produit.getReference() == null || produit.getReference().isBlank()) {
			throw new EntityNotValidException();
		}
		
		if (produit.getModele() == null || produit.getModele().isBlank()) {
			throw new EntityNotValidException();
		}
		
		if (produit.getFournisseur() == null || produit.getFournisseur().getId() == 0) {
			throw new EntityNotValidException();
		}
		
		if (produit.getPrixAchat() < 0) {
			throw new EntityNotValidException();
		}
		
		if (produit.getPrixVente() < 0) {
			throw new EntityNotValidException();
		}
		
		this.repoProduit.save(produit);
	}
	
	public void deleteById(int id) {
		if (id <= 0) {
			throw new InvalidArgsException(); // Si on arrive ici, la méthode s'arrête (comme un return)
		}
		
		this.repoProduit.deleteById(id);
	}
}
