package fr.formation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.formation.model.Fournisseur;
import fr.formation.model.Produit;

public class ApplicationFindProduitSql {

	public static void main(String[] args) {
		Connection myConnection = null;
		
		try {
			// 1- Se connecter au serveur SGBD
			
			// URL de connexion = jdbc:pilote://hote:port/base_de_donnees (jdbc = Java DataBase Connection)
			myConnection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/eshop", "postgres", "root");
			
			// 2- Créer un Statement pour exécuter une requête SQL
//			Statement myStatement = myConnection.createStatement();
			
			// 3- Exécuter une requête SQL de SELECT, stocker son résultat dans un ResultSet
			int produitId = 3;
//			ResultSet myResult = myStatement.executeQuery("SELECT * FROM produit WHERE pro_id = " + produitId);
			
			
			// 2- Créer un Statement pour exécuter une requête SQL
			
			// On va utiliser une requête préparée pour éviter les injections SQL pour simplifier la syntaxe
			PreparedStatement myStatement = myConnection.prepareStatement("SELECT * FROM produit WHERE pro_id = ?");
			
			// On injecte les paramètres à la requête (l'index commence à 1)
			myStatement.setInt(1, produitId);
			
			// 3- Récupérer le résultat du SELECT, et le stocker dans un ResultSet
			ResultSet myResult = myStatement.executeQuery();
			
			Produit monProduit = null;
			
			// 4- Parcourir le ResultSet
			if (myResult.next()) {
				// Pour chaque résultat, il faudra créer un nouveau Produit (java) et un nouveau Fournisseur
				monProduit = new Produit();
				Fournisseur monFournisseur = new Fournisseur();
				
				// On associe toutes les informations du produit
				monProduit.setId( myResult.getInt("pro_id") );
				monProduit.setNom( myResult.getString("pro_nom") );
				monProduit.setPrixAchat( myResult.getFloat("pro_prix_achat") );
				monProduit.setPrixVente( myResult.getFloat("pro_prix_vente") );
				
				// On associe toutes les infos du fournisseur
				monFournisseur.setId( myResult.getInt("pro_fournisseur_id") );
				
				// On associe le fournisseur au produit
				monProduit.setFournisseur(monFournisseur);
			}
			
			
			// On vérifie si on a un produit
			if (monProduit != null) {
				System.out.println(monProduit);
				System.out.println("Fournisseur => " + monProduit.getFournisseur().getId());
			}
			
			else {
				System.out.println("Le produit n'a pas été trouvé.");
			}
			
		}
		
		catch (SQLException e) {
			e.printStackTrace(); // Imprimer l'erreur
			// No suitable driver found => PAS DE PILOTE OU MAUVAIS NOM D'URL
			
		}
		
		finally {
			if (myConnection != null) {
				try {
					// 5- Fermeture de la connexion
					myConnection.close();
				}
				
				catch (SQLException e) {
					System.out.println("Impossible de fermer la connexion.");
				}
			}
		}
	}

}
