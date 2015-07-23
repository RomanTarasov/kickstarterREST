package ua.goit.rest;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.goit.rest.dao.CommentDao;
import ua.goit.rest.dao.ProjectDao;
import ua.goit.rest.entity.Comment;
import ua.goit.rest.entity.Project;

public class CommentDaoTest {
	ApplicationContext app;
	CommentDao commentDao;
	ProjectDao projectDao;

	@Before
	public void setUp() {
		app = new ClassPathXmlApplicationContext("root-context.xml");
		commentDao = (CommentDao) app.getBean("commentDaoImpl");
		projectDao = (ProjectDao) app.getBean("projectDaoImpl");
		// org.hsqldb.util.DatabaseManagerSwing.main(new String[] { "--url",
		// "jdbc:hsqldb:mem:embeddedDataSource", "--noexit"});

	}

	@Test
	public void getCommentsByProject_Test() {
		Project project = projectDao.getById((long) 1);
		List<Comment> comments = commentDao.getAllCommentsOfProject(project);
		assertEquals((Long) (long) 1, comments.get(0).getId());
	}
}
