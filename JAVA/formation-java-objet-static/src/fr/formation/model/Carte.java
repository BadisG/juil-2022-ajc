package fr.formation.model;

public class Carte {
	// Attributs
	private static int compteur = 0;
	private int id = 0;
	private String nom;
	private int valeur;

	// Getters / Setters
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}
	
	
	// Constructeurs
	// La ré-écriture des constructeurs (et des méthodes aussi) => polymorphisme ad-hoc
	public Carte(String nom, int valeur) {
		this.nom = nom;
		this.valeur = valeur;
		System.out.println("CREATION DE LA CARTE");
	}
	
	public Carte(int valeur) {
		System.out.println("SECOND CONSTRUCTEUR");
	}
	
	public Carte() {
		this.id = this.id + 1;
//		System.out.println(this.id);
		
		compteur = compteur + 1;
		System.out.println(compteur);
	}
	
	public void resetCompteur() {
		compteur = 0;
	}
	
	public static void resetCompteurStatic() {
		compteur = 0;
	}
	
	
	
	// Methodes éventuelles ...

}
