package fr.formation.route;

public class Voiture extends Vehicule {
	@Override
	public void rouler() {
		System.out.println(" La voiture roule à " + this.vitesseMax);
	}
}
