package fr.formation.service;

import fr.formation.zoo.Animal;

public interface AnimalService {
	public void sauvegarder(Animal animal);
	// En fait, dans une interface, TOUTES LES METHODES SONT PUBLIQUES
	void supprimer(Animal animal);
}
