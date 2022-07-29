package fr.formation;

import fr.formation.model.Carte;

public class ApplicationReference {

	public static void main(String[] args) {
		Carte maCarte = new Carte("Carte TOTO", 42);
		
		maCarte = magic(maCarte);
		
		System.out.println(maCarte.getNom() + ", " + maCarte.getValeur());
		
	}
	
	public static Carte magic(Carte c) {
		c = new Carte();
		c.setNom("MAGIE");
		
		return c;
	}

}
