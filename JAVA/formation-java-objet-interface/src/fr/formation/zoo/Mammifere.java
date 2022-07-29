package fr.formation.zoo;

public abstract class Mammifere extends Animal {
	public abstract void dormir();
	
	@Override
	public void marcher() {
		System.out.println("Le mammifère marche ...");
	}
}
