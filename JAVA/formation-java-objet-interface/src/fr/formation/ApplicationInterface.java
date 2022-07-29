package fr.formation;

import fr.formation.service.AnimalService;
import fr.formation.service.AnimalServiceBdd;
import fr.formation.zoo.Chat;

public class ApplicationInterface {

	public static void main(String[] args) {
		// Le fait d'utiliser le type "le plus haut" (l'interface / classe mère abstraite)
		// > Couplage faible
		AnimalService service = new AnimalServiceBdd();
		
		service.sauvegarder(new Chat());
		demo(service);
	}
	
	public static void demo(AnimalService service) {
		service.supprimer(null);
	}
}
