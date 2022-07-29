package fr.formation;

import fr.formation.zoo.Animal;
import fr.formation.zoo.Chat;
import fr.formation.zoo.Chien;
import fr.formation.zoo.Mammifere;
import fr.formation.zoo.Singe;

public class ApplicationZoo {

	public static void main(String[] args) {
		Mammifere albert = new Chat();
		Mammifere nono = new Singe();
		Chien zoro = new Chien();
		
		albert.marcher();
		nono.marcher();
		
		albert.getType();
		nono.getType();
		
		albert.dormir();
		nono.dormir();
		zoro.dormir();
		
//		albert.setNom("Albert");
//		albert.dormir();
		
		System.out.println(albert);
		
	}

}
