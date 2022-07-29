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
	
	// Le fait de ré-écrire la méthode dans une classe fille (la re-définition)
	// -> Polymorphisme d'héritage
	@Override
	public void dormir() {
//		this.dormir(); // this fait référence à l'instance en cours
		super.dormir(); // super fait référence à l'instance en cours, mais force l'appel au(x) niveau(x) supérieur(s)
		System.out.println("Le chat dort ...");
	}
	
	@Override
	public String toString() {
		return "[" + super.toString() + "] Le chat " + this.nom;
	}
	
	@Override
	public void marcher() {
		super.marcher();
		System.out.println("Le chat marche à 4 pattes ...");
	}

	@Override
	public void getType() {
		System.out.println("Je suis un chat sans aucun doute !");
	}
}
