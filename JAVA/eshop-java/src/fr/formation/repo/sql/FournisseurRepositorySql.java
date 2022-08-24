package fr.formation.repo.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.formation.model.Fournisseur;
import fr.formation.repo.IFournisseurRepository;

public class FournisseurRepositorySql extends AbstractRepositorySql<Fournisseur> implements IFournisseurRepository {
	// Méthode pour générer les fournisseurs
	protected Fournisseur map(ResultSet myResult) {
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
		try {
			PreparedStatement myStatement = this.prepare("SELECT * FROM fournisseur WHERE fou_id = ?");
			
			myStatement.setInt(1, id);
			
			ResultSet myResult = myStatement.executeQuery();
			
			if (myResult.next()) {
				return this.map(myResult);
			}
		}
		
		catch (SQLException e) {
			return null;			
		}
		
		finally {
			this.disconnect();
		}
		
		return null;
	}

	@Override
	public void save(Fournisseur entity) {
		try {
			PreparedStatement myStatement = null;
			
			if (entity.getId() == 0) { // INSERT
				myStatement = this.prepare("INSERT INTO fournisseur (fou_nom, fou_responsable) VALUES (?, ?)");
			}
			
			else { // UPDATE
				myStatement = this.prepare("UPDATE fournisseur SET "
						+ "fou_nom = ?, "
						+ "fou_responsable = ? "
						+ "WHERE fou_id = ?");

				myStatement.setInt(3, entity.getId());
			}
			
			myStatement.setString(1, entity.getNom());
			myStatement.setString(2, entity.getResponsable());
			
			myStatement.executeUpdate();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			this.disconnect();
		}
	}

	@Override
	public void deleteById(Integer id) {
		try {
			PreparedStatement myStatement = this.prepare("DELETE FROM fournisseur WHERE fou_id = ?");
			
			myStatement.setInt(1, id);
			
			myStatement.executeUpdate();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
