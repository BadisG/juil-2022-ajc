package fr.formation.repo.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.formation.model.Fournisseur;
import fr.formation.model.Produit;
import fr.formation.repo.IProduitRepository;

public class ProduitRepositorySql implements IProduitRepository {
	private Connection connection = null;
	
	// Méthode pour se connecter
	private Connection connect() throws SQLException {
		// 1- Se connecter au serveur SGBD
		this.connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/eshop", "postgres", "root");
		
		return this.connection;
	}
	
	// Méthode pour exécuter une requête SQL
	private PreparedStatement prepare(String query) throws SQLException {
//		this.connect();
//		return this.connection.prepareStatement(query);
		
		return this.connect().prepareStatement(query);
	}
	
	// Méthode pour se déconnecter
	private void disconnect() {
		if (this.connection != null) {
			try {
				this.connection.close();
			}
			
			catch (SQLException e) {
				System.out.println("La déconnexion n'a pas fonctionné.");
			}
		}
	}
	
	// Méthode pour générer les produits / fournisseurs
	private Produit map(ResultSet myResult) {
		try {
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
			
			return monProduit;
		}
		
		catch (SQLException e) {
			return null;
		}
	}
	
	
	@Override
	public Produit findById(Integer id) {
		try {
			PreparedStatement myStatement = this.prepare("SELECT * FROM produit WHERE pro_id = ?");
			
			// On injecte les paramètres à la requête (l'index commence à 1)
			myStatement.setInt(1, id);
			
			// 3- Récupérer le résultat du SELECT, et le stocker dans un ResultSet
			ResultSet myResult = myStatement.executeQuery();
			
			Produit monProduit = null;
			
			// 4- Parcourir le ResultSet
			if (myResult.next()) {
				monProduit = this.map(myResult);
			}
			
			return monProduit;
		}
		
		catch (SQLException e) {
			e.printStackTrace(); // Imprimer l'erreur
		}
		
		finally {
			this.disconnect();
		}
		
		return null;
	}

	@Override
	public List<Produit> findAll() {
		List<Produit> produits = new ArrayList<>();
		
		try {
			PreparedStatement myStatement = this.prepare("SELECT * FROM produit");
			
			// 3- Récupérer le résultat du SELECT, et le stocker dans un ResultSet
			ResultSet myResult = myStatement.executeQuery();
			
			// 4- Parcourir le ResultSet
			while (myResult.next()) {
				Produit monProduit = this.map(myResult);
				
				// On ajoute le produit à la liste
				produits.add(monProduit);
			}
		}
		
		catch (SQLException e) {
			e.printStackTrace(); // Imprimer l'erreur
		}
		
		finally {
			this.disconnect();
		}
		
		return produits;
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
