package fr.formation.service;

import fr.formation.zoo.Animal;

public class AnimalServiceFichier implements AnimalService {
	public void sauvegarder(Animal animal) {
		System.out.println("Sauvegarde dans le fichier");
	}

	@Override
	public void supprimer(Animal animal) {
		System.out.println("Suppression du fichier");
	}
}
