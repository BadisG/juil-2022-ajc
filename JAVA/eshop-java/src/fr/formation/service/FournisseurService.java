package fr.formation.service;

import java.util.ArrayList;
import java.util.List;

import fr.formation.exception.FournisseurNotFoundException;
import fr.formation.exception.IdNegativeException;
import fr.formation.exception.NotValidException;
import fr.formation.model.Fournisseur;
import fr.formation.repo.IFournisseurRepository;
import fr.formation.repo.sql.FournisseurRepositorySql;

public class FournisseurService {
	private IFournisseurRepository repoFournisseur = new FournisseurRepositorySql();
	
	public List<Fournisseur> findAll() {
		List<Fournisseur> fournisseurs = repoFournisseur.findAll();
		
		if (fournisseurs == null) {
			return new ArrayList<>();
		}
		
		return fournisseurs;
	}
	
	public Fournisseur findById(int id) throws IdNegativeException {
		if (id <= 0) {
			throw new IdNegativeException();
		}
		
		Fournisseur fournisseur = repoFournisseur.findById(id);
		
		if (fournisseur == null) {
			throw new FournisseurNotFoundException();
		}
		
		return fournisseur;
	}
	
	public void save(Fournisseur fournisseur) {
		if (fournisseur.getNom() == null || fournisseur.getNom().isBlank()) {
			throw new NotValidException();
		}
		
		if (fournisseur.getResponsable() == null || fournisseur.getResponsable().isBlank()) {
			throw new NotValidException();
		}
		
		repoFournisseur.save(fournisseur);
	}
	
	public void deleteById(int id) throws IdNegativeException {
		if (id <= 0) {
			throw new IdNegativeException();
		}
		
		repoFournisseur.deleteById(id);
	}
}
