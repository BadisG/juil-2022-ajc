package fr.formation.zoo;

public abstract class Felide extends Mammifere implements Chasseur {
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
	
	@Override
	public void marcher() {
		super.marcher();
		System.out.println("Le félidé marche ...");
	}
	
	@Override
	public void dormir() {
		System.out.println("Le félidé dort ...");
	}
}
