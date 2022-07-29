package fr.formation.zoo;

public class Chien extends Canide {
	@Override
	public void croquer() {
		System.out.println("Le chien croque");
	}

	@Override
	public void getType() {
		System.out.println("Je suis un chien");
	}

	@Override
	public void dormir() {
		System.out.println("Le chien dort ...");
	}
}
