package fr.formation.service;

import java.time.LocalDate;

import fr.formation.exception.NotValidException;
import fr.formation.model.Commande;
import fr.formation.model.CommandeDetail;
import fr.formation.repo.ICommandeDetailRepository;
import fr.formation.repo.ICommandeRepository;
import fr.formation.repo.sql.CommandeDetailRepositorySql;
import fr.formation.repo.sql.CommandeRepositorySql;

public class CommandeService {
	public void save(Commande commande) {
		ICommandeRepository repoCommande = new CommandeRepositorySql();
		ICommandeDetailRepository repoCommandeDetail = new CommandeDetailRepositorySql();
		
		if (commande.getEtat() == null) {
			throw new NotValidException();
		}
		
		if (commande.getClient() == null || commande.getClient().getId() <= 0) {
			throw new NotValidException();
		}
		
		if (commande.getDetails() == null || commande.getDetails().size() == 0) {
			throw new NotValidException();
		}

		if (commande.getDate() == null) {
			commande.setDate(LocalDate.now());
		}
		
		for (CommandeDetail detail : commande.getDetails()) {
			detail.setCommande(commande);
			detail.setDate(commande.getDate());
			
			if (detail.getProduit() == null || detail.getProduit().getId() <= 0) {
				throw new NotValidException();
			}
			
			if (detail.getMontant() == 0) {
				throw new NotValidException();
			}
			
			if (detail.getQuantite() <= 0) {
				throw new NotValidException();
			}
		}
		
		// Sauvegarde de la commande et du détail
		repoCommande.save(commande);
		
		for (CommandeDetail detail : commande.getDetails()) {
			repoCommandeDetail.save(detail);
		}
	}
}
