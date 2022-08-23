package fr.formation.repo.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.formation.model.Fournisseur;
import fr.formation.model.Produit;
import fr.formation.repo.IProduitRepository;

public class ProduitRepositorySql implements IProduitRepository {
	@Override
	public Produit findById(Integer id) {
		Connection myConnection = null;
		
		try {
			// 1- Se connecter au serveur SGBD
			
			// URL de connexion = jdbc:pilote://hote:port/base_de_donnees (jdbc = Java DataBase Connection)
			myConnection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/eshop", "postgres", "root");
			
			// 2- Créer un Statement pour exécuter une requête SQL
			
			// On va utiliser une requête préparée pour éviter les injections SQL pour simplifier la syntaxe
			PreparedStatement myStatement = myConnection.prepareStatement("SELECT * FROM produit WHERE pro_id = ?");
			
			// On injecte les paramètres à la requête (l'index commence à 1)
			myStatement.setInt(1, id);
			
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
			
			return monProduit;
		}
		
		catch (SQLException e) {
			e.printStackTrace(); // Imprimer l'erreur
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
		
		return null;
	}

	@Override
	public List<Produit> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Produit entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Produit findByNom(String nom) {
		// TODO Auto-generated method stub
		return null;
	}
}
