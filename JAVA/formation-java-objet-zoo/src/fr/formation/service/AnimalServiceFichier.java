package fr.formation.service;

import fr.formation.zoo.Animal;

public class AnimalServiceFichier implements AnimalService {

	@Override
	public void sauvegarder(Animal obj) {
		System.out.println("Sauvegarde dans le fichier");
	}

	@Override
	public void supprimer(Animal obj) {
		System.out.println("Suppression du fichier");
	}

	

}
