package fr.formation.repo.sql;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.formation.model.CommandeDetail;
import fr.formation.repo.ICommandeDetailRepository;

public class CommandeDetailRepositorySql extends AbstractRepositorySql<CommandeDetail> implements ICommandeDetailRepository {
	@Override
	public CommandeDetail findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CommandeDetail> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(CommandeDetail entity) {
		try {
			PreparedStatement statement = this.prepare("INSERT INTO achat"
					+ " (ach_date, ach_montant, ach_quantite, ach_commande_id, ach_produit_id)"
					+ " VALUES (?, ?, ?, ?, ?)");
			
			statement.setDate(1, Date.valueOf(entity.getDate()));
			statement.setFloat(2, entity.getMontant());
			statement.setInt(3, entity.getQuantite());
			statement.setInt(4, entity.getCommande().getId());
			statement.setInt(5, entity.getProduit().getId());
			
			statement.executeUpdate();
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
	protected CommandeDetail map(ResultSet result) {
		// TODO Auto-generated method stub
		return null;
	}
}
