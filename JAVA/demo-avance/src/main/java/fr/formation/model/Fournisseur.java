package fr.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fournisseur")
public class Fournisseur {
	@Id
	@Column(name = "fou_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "fou_nom")
	private String nom;

	@Column(name = "fou_responsable")
	private String responsable;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	
	@Override
	public String toString() {
		return "["
				+ "id = " + this.id + ", "
				+ "nom = " + this.nom + ", "
				+ "responsable = " + this.responsable
			+ "]";
	}
}
