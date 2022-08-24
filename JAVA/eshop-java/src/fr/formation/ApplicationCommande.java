package fr.formation;

import java.util.ArrayList;

import fr.formation.exception.IdNegativeException;
import fr.formation.model.Client;
import fr.formation.model.Commande;
import fr.formation.model.CommandeDetail;
import fr.formation.model.EtatCommande;
import fr.formation.model.Produit;
import fr.formation.service.CommandeService;
import fr.formation.service.ProduitService;

public class ApplicationCommande {
	public static void main(String[] args) throws IdNegativeException {
		CommandeService srvCommande = new CommandeService();
		ProduitService srvProduit = new ProduitService();
		
		// Création de la commande
		Commande commande = new Commande();
		
		commande.setEtat(EtatCommande.ATTENTE);
		commande.setDetails(new ArrayList<>());
		commande.setClient(new Client());
		
		// Commande pour le client #1
		commande.getClient().setId(1);
		
		// Commande avec 2 produits
		Produit p1 = srvProduit.findById(1);
		CommandeDetail detail1 = new CommandeDetail();
		
		detail1.setProduit(p1);
		detail1.setQuantite(1);
		detail1.setMontant(p1.getPrixVente());
		commande.getDetails().add(detail1);

		Produit p2 = srvProduit.findById(1);
		CommandeDetail detail2 = new CommandeDetail();
		
		detail2.setProduit(p2);
		detail2.setQuantite(1);
		detail2.setMontant(p2.getPrixVente());
		commande.getDetails().add(detail2);
		
		// On sauvegarde la commande
		try {
			srvCommande.save(commande);
			System.out.println("La commande a été ajoutée.");
		}
		
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("La commande n'a pas pu être sauvegardée.");
		}
	}
}
