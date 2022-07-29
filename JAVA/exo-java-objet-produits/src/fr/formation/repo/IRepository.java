package fr.formation.repo;

public interface IRepository<T> {
	public T save(T entity);
	public void delete(T entity);
}
