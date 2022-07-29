package fr.formation.zoo;

public abstract class Mammifere extends Animal {
	public void dormir() {
		System.out.println("Le mammifere dort ...");
	}
	
	@Override
	public void marcher() {
		System.out.println("Le mammifère marche ...");
	}
}
