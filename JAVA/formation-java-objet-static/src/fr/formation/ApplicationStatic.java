package fr.formation;

import fr.formation.model.Joueur;

public class ApplicationStatic {

	public static void main(String[] args) {
		Joueur j1 = new Joueur();
		Joueur j2 = new Joueur();
		Joueur j3 = new Joueur();
		
		System.out.println(j1.getId());
		System.out.println(j2.getId());
		System.out.println(j3.getId());
		
		
//		Carte c1 = new Carte();
//		Carte c2 = new Carte();
//		Carte c3 = new Carte();
//		
////		c3.resetCompteur(); // Avec instance "c3"
//		c2.resetCompteur();
////		Carte.resetCompteurStatic(); // Hors instance
//		
//		Carte c4 = new Carte();
	}

}
