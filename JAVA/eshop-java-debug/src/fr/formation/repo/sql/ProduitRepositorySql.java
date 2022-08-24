package fr.formation.repo.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import fr.formation.model.Fournisseur;
import fr.formation.model.Produit;
import fr.formation.repo.IProduitRepository;

public class ProduitRepositorySql extends AbstractRepositorySql<Produit> implements IProduitRepository {
	protected Produit map(ResultSet result) {
		try {
			Produit monProduit = new Produit();
			Fournisseur monFournisseur = new Fournisseur();
			
			monProduit.setId( result.getInt("pro_id") );
			monProduit.setNom( result.getString("pro_nom") );
			monProduit.setPrixAchat( result.getFloat("pro_prix_achat") );
			monProduit.setPrixVente( result.getFloat("pro_prix_vente") );
			monProduit.setModele( result.getString("pro_modele") );
			monProduit.setReference( result.getString("pro_reference") );
			
			monFournisseur.setId( result.getInt("pro_fournisseur_id") );
			
			monProduit.setFournisseur(monFournisseur);
			
			return monProduit;
		}
		
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	@Override
	public Produit findById(Integer id) {
		try {
			PreparedStatement myStatement = this.prepare("SELECT * FROM produit WHERE pro_id = ?");
			
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
	public List<Produit> findAll() {
		List<Produit> produits = new ArrayList<>();
		
		try {
			PreparedStatement myStatement = this.prepare("SELECT * FROM produit");
			ResultSet myResult = myStatement.executeQuery();
			
			while (myResult.next()) {
				produits.add(this.map(myResult));
			}
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			this.disconnect();
		}
		
		return produits;
	}

	@Override
	public void save(Produit entity) {
		PreparedStatement myStatement = null;
		
		try {
			if (entity.getId() > 0) { // UPDATE
				myStatement = this.prepare("UPDATE produit SET"
						+ " pro_nom = ?,"
						+ " pro_reference = ?,"
						+ " pro_prix_achat = ?,"
						+ " pro_prix_vente = ?,"
						+ " pro_modele = ?,"
						+ " pro_fournisseur_id = ?"
						+ " WHERE pro_id = ?");
				
				myStatement.setInt(7, entity.getId());
			}
			
			else {
				myStatement = this.prepare("INSERT INTO produit"
						+ " (pro_nom, pro_reference, pro_prix_achat, pro_prix_vente, pro_modele, pro_fournisseur_id)"
						+ " VALUES (?, ?, ?, ?, ?, ?)");
			}

			myStatement.setString(1, entity.getNom());
			myStatement.setString(2, entity.getReference());
			myStatement.setFloat(3, entity.getPrixAchat());
			myStatement.setFloat(4, entity.getPrixVente());
			myStatement.setString(5, entity.getModele());
			myStatement.setInt(6, entity.getFournisseur().getId());
			
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
			PreparedStatement myStatement = this.prepare("DELETE FROM produit WHERE pro_id = ?");
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

	@Override
	public Optional<Produit> findByNom(String nom) {
		try {
			PreparedStatement myStatement = this.prepare("SELECT * FROM produit WHERE pro_nom = ?");
			
			myStatement.setString(1, nom);
			
			ResultSet myResult = myStatement.executeQuery();
			
			if (myResult.next()) {
				return Optional.ofNullable(this.map(myResult));
			}
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			this.disconnect();
		}
		
		return Optional.empty();
	}
}
