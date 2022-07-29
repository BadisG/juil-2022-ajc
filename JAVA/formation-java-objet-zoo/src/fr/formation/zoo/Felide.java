package fr.formation.zoo;

public class Felide extends Mammifere {
	protected String nom;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public Felide() {
		System.out.println("CREATION D'UN FELIDE");
	}
	
	@Override
	public String toString() {
		return "FELIDE";
	}
}
