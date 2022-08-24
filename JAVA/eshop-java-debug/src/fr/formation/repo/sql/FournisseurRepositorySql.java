package fr.formation.repo.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.formation.model.Fournisseur;
import fr.formation.repo.IFournisseurRepository;

public class FournisseurRepositorySql extends AbstractRepositorySql<Fournisseur> implements IFournisseurRepository {
	protected Fournisseur map(ResultSet result) {
		try {
			Fournisseur monFournisseur = new Fournisseur();
			
			monFournisseur.setId( result.getInt("fou_id") );
			monFournisseur.setNom( result.getString("fou_nom") );
			monFournisseur.setResponsable( result.getString("fou_responsable") );
			
			return monFournisseur;
		}
		
		catch (SQLException e) {
			e.printStackTrace();
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
			e.printStackTrace();
		}
		
		finally {
			this.disconnect();
		}
		
		return null;
	}

	@Override
	public void save(Fournisseur entity) {
		PreparedStatement myStatement = null;
		
		try {
			if (entity.getId() > 0) { // UPDATE
				myStatement = this.prepare("UPDATE fournisseur SET"
						+ " fou_nom = ?,"
						+ " fou_responsable = ?"
						+ " WHERE fou_id = ?");
				
				myStatement.setInt(3, entity.getId());
			}
			
			else {
				myStatement = this.prepare("INSERT INTO fournisseur"
						+ " (fou_nom, fou_responsable)"
						+ " VALUES (?, ?)");
			}

			myStatement.setString(1, entity.getNom());
			myStatement.setString(2, entity.getResponsable());
			
			myStatement.execute();
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
			myStatement.execute();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			this.disconnect();
		}
	}

}
