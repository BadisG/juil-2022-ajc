package fr.formation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.exception.FournisseurNotFoundException;
import fr.formation.exception.NotValidArgsException;
import fr.formation.model.Fournisseur;
import fr.formation.repo.IFournisseurRepository;

@Service
public class FournisseurService {
	@Autowired
	private IFournisseurRepository repoFournisseur;
	
	public Fournisseur findById(int id) {
		if (id <= 0) {
			throw new NotValidArgsException();
		}
		
		return this.repoFournisseur.findById(id).orElseThrow(FournisseurNotFoundException::new);
	}
}
