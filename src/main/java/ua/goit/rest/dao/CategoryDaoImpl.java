package ua.goit.rest.dao;

import java.util.List;

import javax.transaction.Transactional;



import ua.goit.rest.entity.Category;


@Transactional
public class CategoryDaoImpl extends AbstractDao<Category> implements
		CategoryDao {
	CategoryDaoImpl() {
		super(Category.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getAllCategories() {
		return sessionFactory.getCurrentSession()
				.createCriteria(Category.class).list();
	}
}
