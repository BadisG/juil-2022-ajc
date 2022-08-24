package fr.formation.service;

import java.util.ArrayList;
import java.util.List;

import fr.formation.exception.IdNegativeException;
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
	
	public void deleteById(int id) throws IdNegativeException {
		if (id <= 0) {
			throw new IdNegativeException();
		}
		
		repoFournisseur.deleteById(id);
	}
}
