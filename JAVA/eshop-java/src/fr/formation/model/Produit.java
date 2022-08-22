package fr.formation.model;

public class Produit {
	private int id;
	private String nom;
	private String reference;
	private float prixAchat;
	private float prixVente;
//	private double prixAchat;
//	private BigDecimal prixAchat // Utilisable pour les chiffres à virgules
	private String modele;
	private Fournisseur fournisseur; // On ne récupère pas l'id, puisqu'on va parler en graphe d'objets

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

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public float getPrixAchat() {
		return prixAchat;
	}

	public void setPrixAchat(float prixAchat) {
		this.prixAchat = prixAchat;
	}

	public float getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(float prixVente) {
		this.prixVente = prixVente;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}
	
	@Override
	public String toString() {
		return "[id = " + this.id + ", nom = " + this.nom + ", prixAchat = " + this.prixAchat + ", prixVente = " + this.prixVente + "]";
	}
}
