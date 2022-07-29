package fr.formation.service;

public interface GenericService<T> {
	public void sauvegarder(T obj);
	public void supprimer(T obj);
}
