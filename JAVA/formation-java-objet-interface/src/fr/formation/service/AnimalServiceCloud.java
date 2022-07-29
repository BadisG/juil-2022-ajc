package fr.formation.service;

import fr.formation.zoo.Animal;

public class AnimalServiceCloud implements AnimalService {
	@Override
	public void sauvegarder(Animal animal) {
		System.out.println("Sauvegarde dans le cloud");
	}

	@Override
	public void supprimer(Animal animal) {
		System.out.println("Suppression du cloud");
	}
}
