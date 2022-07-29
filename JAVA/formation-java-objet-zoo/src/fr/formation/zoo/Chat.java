package fr.formation.zoo;

// extends => dérive de ... Felide
public class Chat extends Felide {
	public Chat() {
		System.out.println("CREATION D'UN CHAT");
	}
	
	public Chat(String nom) {
		this.nom = nom;
		System.out.println("CREATION DU CHAT " + nom);
	}
}
