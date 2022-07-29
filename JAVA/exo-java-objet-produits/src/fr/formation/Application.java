package fr.formation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import fr.formation.model.Fournisseur;
import fr.formation.model.Produit;

public class Application {

	public static void main(String[] args) {
		// Création du fournisseur
		Fournisseur fournisseur = new Fournisseur();
		fournisseur.setId(1);
		fournisseur.setNom("AMAZON");
		
		
		// Création des produits (dans une liste de produits)
		List<Produit> produits = new ArrayList<>();
		
		
		// Produit 1
		Produit p1 = new Produit();
		p1.setId(1);
		p1.setNom("PARACHUTE DE FRANCE");
		p1.setPrix(5000.50f); // petit "f" derrière pour forcer Java à utiliser un float
		p1.setFournisseur(fournisseur);
		produits.add(p1);

		// Produit 2
		Produit p2 = new Produit();
		p2.setId(2);
		p2.setNom("COMBINAISON ETE");
		p2.setPrix(499.99f); // petit "f" derrière pour forcer Java à utiliser un float
		p2.setFournisseur(fournisseur);
		produits.add(p2);
		
		
		// Affichage des produits
		for (Produit produit : produits) {
//			System.out.println(produit); // Modifier le toString
			System.out.println(
					produit.getNom() + ", " +
					produit.getPrix() + " euros, founi par " +
					produit.getFournisseur().getNom()
			);
		}
		
		
//		couplageFort(produits);
		couplageFaible(produits);
		
	}
	
	public static void couplageFort(ArrayList<Produit> produits) {
		
	}
	
	public static void couplageFaible(List<Produit> produits) {
		
	}

}
