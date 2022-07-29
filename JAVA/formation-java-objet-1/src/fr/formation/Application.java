package fr.formation;

import java.util.ArrayList;
import java.util.Iterator;

import fr.formation.model.Carte;

public class Application {

	public static void main(String[] args) {
		
//		System.out.println("Hello !!!");
		
//		Carte maCarte = new Carte();
//		
//		maCarte.setNom("As de Pique");
//		maCarte.setValeur(10);
//		
//		
//		System.out.println(maCarte.getNom() + ", " + maCarte.getValeur());
		
		
		// Création du paquet de cartes
		ArrayList<Carte> paquet = new ArrayList<>();
		
		for (int i = 1; i <= 32; i++) {
			Carte laCarte = new Carte("Carte #" + i, i);
			
//			laCarte.setNom("Carte #" + i);
//			laCarte.setValeur(i);
			
			// On ajoute la carte à la liste
			paquet.add(laCarte);
		}
		
		
		// Affichage du paquet (pour chaque)
		for (Carte carte : paquet) {
			System.out.println(carte.getNom() + ", " + carte.getValeur());
		}
	}

}
