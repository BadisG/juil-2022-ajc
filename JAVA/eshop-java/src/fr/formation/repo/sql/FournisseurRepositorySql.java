package fr.formation.repo.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.formation.model.Fournisseur;
import fr.formation.repo.IFournisseurRepository;

public class FournisseurRepositorySql implements IFournisseurRepository {
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
	
	// Méthode pour générer les fournisseurs
	private Fournisseur map(ResultSet myResult) {
		try {
			// Pour chaque résultat, il faudra créer un nouveau Fournisseur
			Fournisseur monFournisseur = new Fournisseur();
			
			// On associe toutes les infos du fournisseur
			monFournisseur.setId( myResult.getInt("fou_id") );
			monFournisseur.setNom( myResult.getString("fou_nom") );
			monFournisseur.setResponsable( myResult.getString("fou_responsable") );
			
			return monFournisseur;
		}
		
		catch (SQLException e) {
			return null;
		}
	}
	

	@Override
	public List<Fournisseur> findAll() {
		List<Fournisseur> fournisseurs = new ArrayList<>();
		
		try {
			PreparedStatement myStatement = this.prepare("SELECT * FROM fournisseur");
			ResultSet myResult = myStatement.executeQuery();
			
			while (myResult.next()) {
				fournisseurs.add(this.map(myResult));
			}
		}
		
		catch (SQLException e) {
			e.printStackTrace(); // On le laisse en dév | TODO : à supprimer plus tard
		}
		
		finally {
			this.disconnect();
		}
		
		return fournisseurs;
	}
	
	
	
	
	
	
	
	

	@Override
	public Fournisseur findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Fournisseur entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
