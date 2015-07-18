package ua.goit.rest.dao;

import javax.transaction.Transactional;

@Transactional
public interface Dao<T> {
	void create(T entity);

	T getById(Long id);

	void update(T entity);

	void delete(T entity);
}
