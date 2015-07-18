package ua.goit.rest.dao;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class AbstractDao<T> implements Dao<T> {

	@Autowired
	protected SessionFactory sessionFactory;
	Class<T> type;

	AbstractDao(Class<T> type) {
		this.type = type;
	}

	@Override
	public void create(T entity) {
		sessionFactory.getCurrentSession().save(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getById(Long id) {
		return (T) sessionFactory.getCurrentSession().get(type, id);
	}

	@Override
	public void update(T entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public void delete(T entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}
}
