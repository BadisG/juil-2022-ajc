package fr.formation.repo.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AbstractRepositorySql<T> {
	protected Connection connection = null;
	
	// Méthode pour se connecter
	protected Connection connect() throws SQLException {
		// 1- Se connecter au serveur SGBD
		this.connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/eshop", "postgres", "root");
		
		return this.connection;
	}
	
	// Méthode pour exécuter une requête SQL
	protected PreparedStatement prepare(String query) throws SQLException {
//			this.connect();
//			return this.connection.prepareStatement(query);
		
		return this.connect().prepareStatement(query);
	}
	
	// Méthode pour se déconnecter
	protected void disconnect() {
		if (this.connection != null) {
			try {
				this.connection.close();
			}
			
			catch (SQLException e) {
				System.out.println("La déconnexion n'a pas fonctionné.");
			}
		}
	}
	
	protected abstract T map(ResultSet result);
}
