package fr.formation;

import fr.formation.model.TypePersonne;

public class ApplicationEnum {

	public static void main(String[] args) {
		// 2 solutions (+1 enum)
		
		// Solution #1 : entier
		// Si 0, c'est un client
		// Si 1, c'est un fournisseur
		
		int typePersonne = 0;
		
		if (typePersonne == 0) {
			System.out.println("CLIENT");
		}
		else if (typePersonne == 1) {
			System.out.println("FOURNISSEUR");
		}
		
		// Solution #2 : string
		// Si "client", c'est un client
		// Si "fournisseur", c'est un fournisseur
		
		String typePersonneStr = "Client";
		
		switch (typePersonneStr) {
			case "client":
				System.out.println("CLIENT");
				break;
			case "fournisseur":
				System.out.println("FOURNISSEUR");
				break;
			default: System.out.println("PAS CONNU"); // PAS OBLIGATOIRE
		}
		
		
		// Solution la plus efficace : enum
		TypePersonne typePersonneEnum = TypePersonne.CLIENT;
		
		if (typePersonneEnum == TypePersonne.CLIENT) {
			System.out.println("CLIENT");
		}
		
		switch (typePersonneEnum) {
			case FOURNISSEUR:
				System.out.println("FOURNISSEUR");
				break;
		}
	}

}
