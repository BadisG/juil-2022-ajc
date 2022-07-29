package fr.formation;

import fr.formation.zoo.Chat;
import fr.formation.zoo.Mammifere;

public class ApplicationZoo {

	public static void main(String[] args) {
		Object albert = new Chat();
		
//		albert.dormir();
		
		// Le casting : (TypeAUtiliser)variable
		
		// Tester le type d'une variable
		if (albert instanceof String) {
			// Albert est un String
			((String)albert).toLowerCase();
		}
		
		else if (albert instanceof Mammifere) {
			// Albert est un Mammifere
			((Mammifere)albert).dormir();
		}
		
		
//		System.out.println(albert);
//		albert.setNom("Albert");
	}

}
