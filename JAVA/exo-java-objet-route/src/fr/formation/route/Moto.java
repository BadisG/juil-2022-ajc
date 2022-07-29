package fr.formation.route;

public class Moto extends Vehicule {
	@Override
	public void rouler() {
		System.out.println(" La moto fonce à " + this.vitesseMax);
	}
}
