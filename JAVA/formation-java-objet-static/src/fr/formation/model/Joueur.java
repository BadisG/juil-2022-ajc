package fr.formation.model;

public class Joueur {
	private static int compteur = 1;
//	private int id = compteur++; // Sans le constructeur
	private int id; // Avec le constructeur

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Joueur() {
		this.id = compteur++;
	}
}
