package fr.formation.model;

import java.util.List;

public class Fournisseur {
	private int id;
	private String nom;
	private String responsable;
	private List<Produit> produits; // Liste optionnelle, utile si on veut la liste des produits pour le fournisseur

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

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	
	@Override
	public String toString() {
		return "["
				+ "id = " + this.id + ", "
				+ "nom = " + this.nom + ", "
				+ "responsable = " + this.responsable
				+"]";
	}
}
