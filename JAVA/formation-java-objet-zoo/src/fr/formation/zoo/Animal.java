package fr.formation.zoo;

public abstract class Animal {
	public void manger() {
		System.out.println("L'animal mange ...");
	}
	
	public abstract void marcher();
	
//	public void getType() {
//
//		if (this instanceof Chat) {
//			System.out.println("Je suis un chat");
//		}
//		
//		else if (this instanceof Singe) {
//			System.out.println("Je suis un singe");
//		}
//	}
	
	public abstract void getType();
}
