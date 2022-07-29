package fr.formation;

import fr.formation.model.Carte;

public class ApplicationStatic {

	public static void main(String[] args) {
		Carte c1 = new Carte();
		Carte c2 = new Carte();
		Carte c3 = new Carte();
		
//		c3.resetCompteur(); // Avec instance "c3"
		c2.resetCompteur();
//		Carte.resetCompteurStatic(); // Hors instance
		
		Carte c4 = new Carte();
	}

}
