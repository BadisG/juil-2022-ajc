package fr.formation;

import java.util.InputMismatchException;
import java.util.Scanner;

import fr.formation.exception.IdNegativeException;
import fr.formation.exception.ProduitNotFoundException;
import fr.formation.model.Produit;
import fr.formation.service.ProduitService;

public class ApplicationProduitException {

	public static void main(String[] args) {
		ProduitService srvProduit = new ProduitService();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Saisir l'id du produit à rechercher : ");
		
		try {
			int idProduit = sc.nextInt();
			Produit monProduit = srvProduit.findById(idProduit);
			System.out.println("Produit trouvé : " + monProduit.getNom());
		}

		catch (InputMismatchException e) { // Autre chose qu'un entier saisi
			System.out.println("Oups, mauvaise saisie");
		}

		catch (ProduitNotFoundException e) { // Produit n'existe pas
			System.out.println("Oups, produit non trouvé");
		}

		catch (IdNegativeException e) { // L'id n'est pas cohérent
			System.out.println("Oups, l'id doit être positif");
		}
		
		catch (Exception e) {
			System.out.println("Oups, une erreur est survenue");
		}
		
		sc.close();
		System.out.println("FIN !");
		
	}

}
