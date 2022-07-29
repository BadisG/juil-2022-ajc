package fr.formation;

import java.util.ArrayList;

import fr.formation.route.Camion;
import fr.formation.route.Moto;
import fr.formation.route.Vehicule;
import fr.formation.route.Voiture;

public class ApplicationRoute {

	public static void main(String[] args) {
		// La génération des différents véhicules
		ArrayList<Vehicule> vehicules = new ArrayList<>();
		
		Voiture clio = new Voiture();
		clio.setVitesseMax(180);
		clio.setNbRoues(4);
		
		Moto honda = new Moto();
		honda.setVitesseMax(280);
		honda.setNbRoues(2);
		
		Camion camion = new Camion();
		camion.setVitesseMax(110);
		camion.setNbRoues(8);
		
		// On ajoute les véhicules à la liste
		vehicules.add(clio);
		vehicules.add(honda);
		vehicules.add(camion);
		
		
		// Parcours de la liste des véhicules, puis l'appelle aux méthodes rouler()
		for (Vehicule v : vehicules) {
			v.rouler();
		}
	}

}
