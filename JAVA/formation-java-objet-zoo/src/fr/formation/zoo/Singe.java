package fr.formation.zoo;

public class Singe extends Mammifere {
	@Override
	public void marcher() {
		super.marcher();
		System.out.println("Le singe marche parfois sur 2 pattes ...");
	}

	@Override
	public void getType() {
		System.out.println("Je suis singe");
	}
}
