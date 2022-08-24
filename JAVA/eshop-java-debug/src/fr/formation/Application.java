package fr.formation;

import fr.formation.exception.EntityNotValidException;
import fr.formation.exception.FournisseurNotFoundException;
import fr.formation.exception.InvalidArgsException;
import fr.formation.exception.ProduitNotFoundException;
import fr.formation.model.Fournisseur;
import fr.formation.model.Produit;
import fr.formation.service.FournisseurService;
import fr.formation.service.ProduitService;

public class Application {
	private static FournisseurService srvFournisseur = new FournisseurService();
	private static ProduitService srvProduit = new ProduitService();
	
	public static void main(String[] args) {
//		findAllProduits();
//		findProduitById();
//		findProduitByNom();
//		updateProduit();

//		findAllFournisseurs();
//		addFournisseur();
//		deleteFournisseur();
		findFournisseurById();
	}

	private static void findAllFournisseurs() {
		for (Fournisseur f : srvFournisseur.findAll()) {
			System.out.println(f);
		}
	}
	
	private static void findAllProduits() {
		for (Produit p : srvProduit.findAll()) {
			System.out.println(p);
		}
	}
	
	private static void findProduitById() {
		try {
			System.out.println(srvProduit.findById(1));
		}

		catch (ProduitNotFoundException e) {
			System.out.println("Produit non trouvé.");
		}

		catch (InvalidArgsException e) {
			System.out.println("ID pas bon.");
		}
	}
	
	private static void findProduitByNom() {
		try {
			System.out.println(srvProduit.findByNom("GoPRO HERO 7"));
		}

		catch (ProduitNotFoundException e) {
			System.out.println("Produit non trouvé.");
		}

		catch (InvalidArgsException e) {
			System.out.println("ID pas bon.");
		}
	}
	
	private static void addFournisseur() {
		try {
			Fournisseur fournisseur = new Fournisseur();
			fournisseur.setNom("Fournisseur FROM JAVA");
			fournisseur.setResponsable("Responsable ...");
			
			srvFournisseur.save(fournisseur);
			System.out.println("Fournisseur ajouté !");
		}

		catch (EntityNotValidException e) {
			System.out.println("Il manque des choses ....");
		}

		catch (InvalidArgsException e) {
			System.out.println("ID pas bon.");
		}
	}
	
	private static void updateProduit() {
		try {
			Produit produit = srvProduit.findById(1);
			produit.getFournisseur().setId(2);
			
			srvProduit.save(produit);
			System.out.println("Produit sauvegardé !");
		}

		catch (EntityNotValidException e) {
			System.out.println("Il manque des choses ....");
		}

		catch (ProduitNotFoundException e) {
			System.out.println("Produit non trouvé.");
		}
	}
	
	private static void deleteFournisseur() {
		try {
			srvFournisseur.deleteById(9);
			System.out.println("Fournisseur supprimé !");
		}

		catch (InvalidArgsException e) {
			System.out.println("ID pas bon.");
		}
	}
	
	private static void findFournisseurById() {
		try {
			System.out.println(srvFournisseur.findById(1));
		}

		catch (FournisseurNotFoundException e) {
			System.out.println("Fournisseur non trouvé.");
		}

		catch (InvalidArgsException e) {
			System.out.println("ID pas bon.");
		}
	}
}
