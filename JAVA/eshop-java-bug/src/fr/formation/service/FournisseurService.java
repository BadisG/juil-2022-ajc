package fr.formation.service;

import java.util.ArrayList;
import java.util.List;

import fr.formation.exception.EntityNotValidException;
import fr.formation.exception.FournisseurNotFoundException;
import fr.formation.exception.InvalidArgsException;
import fr.formation.model.Fournisseur;
import fr.formation.repo.IFournisseurRepository;
import fr.formation.repo.sql.FournisseurRepositorySql;

public class FournisseurService {
	private IFournisseurRepository repoFournisseur = new FournisseurRepositorySql();
	
	public List<Fournisseur> findAll() {
		List<Fournisseur> fournisseurs = this.repoFournisseur.findAll();
		
		if (fournisseurs == null) {
			return new ArrayList<>();
		}
		
		return fournisseurs;
	}
	
	public Fournisseur findById(int id) {
		if (id <= 0) {
			throw new InvalidArgsException();
		}
		
		Fournisseur fournisseur = this.repoFournisseur.findById(id);
		
		if (fournisseur == null) {
			throw new FournisseurNotFoundException();
		}
		
		return fournisseur;
	}
	
	public void save(Fournisseur fournisseur) {
		if (fournisseur == null) {
			throw new InvalidArgsException();
		}
		
		if (fournisseur.getNom() == null || fournisseur.getNom().isBlank()) {
			throw new EntityNotValidException();
		}
		
		if (fournisseur.getResponsable() == null || fournisseur.getResponsable().isBlank()) {
			throw new EntityNotValidException();
		}
		
		this.repoFournisseur.save(fournisseur);
	}
	
	public void deleteById(int id) {
		if (id <= 0) {
			throw new InvalidArgsException();
		}
		
		this.repoFournisseur.deleteById(id);
	}
}
