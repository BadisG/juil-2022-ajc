package fr.formation;

import fr.formation.zoo.Animal;
import fr.formation.zoo.Chat;
import fr.formation.zoo.Singe;

public class ApplicationZoo {

	public static void main(String[] args) {
		Animal albert = new Chat();
		Animal nono = new Singe();
		
		albert.marcher();
		nono.marcher();
		
		albert.getType();
		nono.getType();
		
//		albert.setNom("Albert");
//		albert.dormir();
		
		System.out.println(albert);
		
	}

}
