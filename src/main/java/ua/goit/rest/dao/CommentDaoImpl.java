package ua.goit.rest.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import ua.goit.rest.entity.Comment;
import ua.goit.rest.entity.Project;

@Transactional
public class CommentDaoImpl extends AbstractDao<Comment> implements CommentDao {
	CommentDaoImpl() {
		super(Comment.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> getAllCommentsOfProject(Project project) {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Comment.class)
				.add(Restrictions.eq("project.id", project.getId())).list();
	}
}
