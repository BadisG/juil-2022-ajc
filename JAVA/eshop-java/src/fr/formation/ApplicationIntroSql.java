package fr.formation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.formation.model.Fournisseur;
import fr.formation.model.Produit;

public class ApplicationIntroSql {

	public static void main(String[] args) {
		Connection myConnection = null;
		
		try {
			// 1- Se connecter au serveur SGBD
			
			// URL de connexion = jdbc:pilote://hote:port/base_de_donnees (jdbc = Java DataBase Connection)
			myConnection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/eshop", "postgres", "root");
			
			// 2- Créer un Statement pour exécuter une requête SQL
			Statement myStatement = myConnection.createStatement();
			
			// 3- Exécuter une requête SQL de SELECT, stocker son résultat dans un ResultSet
			ResultSet myResult = myStatement.executeQuery("SELECT * FROM produit");
			
			List<Produit> produits = new ArrayList<>();
			
			// 4- Parcourir le ResultSet
			while (myResult.next()) {
				// Pour chaque résultat, il faudra créer un nouveau Produit (java) et un nouveau Fournisseur
				Produit monProduit = new Produit();
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
				
				// On ajoute le produit à la liste
				produits.add(monProduit);
				
//				System.out.println( myResult.getString("pro_nom") );				
			}
			
			
			// Parcourir la liste des produits
			for (Produit p : produits) {
				System.out.println(p);
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
