package ua.goit.rest.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import ua.goit.rest.entity.Category;
import ua.goit.rest.entity.Project;


@Transactional
public class ProjectDaoImpl extends AbstractDao<Project> implements ProjectDao {

	ProjectDaoImpl() {
		super(Project.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Project> getProjectsByCategory(Category category) {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Project.class)
				.add(Restrictions.eq("category.id", category.getId())).list();
	}
}
