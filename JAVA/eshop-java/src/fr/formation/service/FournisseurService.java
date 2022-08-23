package fr.formation.service;

import java.util.ArrayList;
import java.util.List;

import fr.formation.model.Fournisseur;
import fr.formation.repo.IFournisseurRepository;
import fr.formation.repo.sql.FournisseurRepositorySql;

public class FournisseurService {
	public List<Fournisseur> findAll() {
		IFournisseurRepository repoFournisseur = new FournisseurRepositorySql();
		List<Fournisseur> fournisseurs = repoFournisseur.findAll();
		
		if (fournisseurs == null) {
			return new ArrayList<>();
		}
		
		return fournisseurs;
	}
}
