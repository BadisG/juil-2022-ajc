package fr.formation.repo.sql;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.formation.model.Commande;
import fr.formation.repo.ICommandeRepository;

public class CommandeRepositorySql extends AbstractRepositorySql<Commande> implements ICommandeRepository {
	@Override
	public Commande findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Commande> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Commande entity) {
		try {
			PreparedStatement statement = this.prepare("INSERT INTO commande"
					+ " (cmd_date, cmd_etat, cmd_client_id)"
					+ " VALUES (?, ?, ?)");
			
			statement.setDate(1, Date.valueOf(entity.getDate()));
			statement.setInt(2, entity.getEtat().ordinal());
			statement.setInt(3, entity.getClient().getId());
			
			statement.executeUpdate();
			
			// On récupère et on affecte l'id de la commande auto-généré (dernier ID ...)
			ResultSet result = this.prepare("SELECT max(cmd_id) FROM commande").executeQuery();
			
			if (result.next()) {
				entity.setId(result.getInt(1));
			}
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
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Commande map(ResultSet result) {
		// TODO Auto-generated method stub
		return null;
	}
}
