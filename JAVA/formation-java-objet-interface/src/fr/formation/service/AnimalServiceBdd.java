package fr.formation.service;

import fr.formation.zoo.Animal;

public class AnimalServiceBdd implements AnimalService {
	public void sauvegarder(Animal animal) {
		System.out.println("Sauvegarde dans la base de données");
	}

	@Override
	public void supprimer(Animal animal) {
		System.out.println("Suppression de la base de données");
	}
}
