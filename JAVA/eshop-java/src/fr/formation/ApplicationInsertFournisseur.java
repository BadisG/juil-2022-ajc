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

public class ApplicationInsertFournisseur {

	public static void main(String[] args) {
		Connection myConnection = null;
		
		try {
			// Fournisseur à insérer en base de données
			Fournisseur monFournisseur = new Fournisseur();
			
			monFournisseur.setNom("Fournisseur from JAVA");
			monFournisseur.setResponsable("Le responsable c'est pas moi");
			
			
			// 1- Se connecter au serveur SGBD
			
			// URL de connexion = jdbc:pilote://hote:port/base_de_donnees (jdbc = Java DataBase Connection)
			myConnection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/eshop", "postgres", "root");
			
			// 2- Créer un Statement pour exécuter une requête SQL
			
			// On va utiliser une requête préparée pour éviter les injections SQL pour simplifier la syntaxe
			PreparedStatement myStatement = myConnection
					.prepareStatement("INSERT INTO fournisseur (fou_nom, fou_responsable) VALUES (?, ?)");
			
			// On injecte les paramètres à la requête (l'index commence à 1)
			myStatement.setString(1, monFournisseur.getNom());
			myStatement.setString(2, monFournisseur.getResponsable());
			
			// 3- Exécuter la requête
			myStatement.execute(); // Retournera un booléen (oui / non selon si ça s'est bien passé ou pas)
//			myStatement.executeUpdate(); // Retournera un int, le nombre de lignes affectées
			
			System.out.println("Le fournisseur a été ajouté.");
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
