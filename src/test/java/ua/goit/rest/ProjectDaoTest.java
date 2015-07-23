package ua.goit.rest;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.goit.rest.dao.ProjectDao;
import ua.goit.rest.entity.Category;
import ua.goit.rest.entity.Project;

public class ProjectDaoTest {
	ApplicationContext app;
	ProjectDao projectDao;

	@Before
	public void setUp() {
		app = new ClassPathXmlApplicationContext("root-context.xml");
		projectDao = (ProjectDao) app.getBean("projectDaoImpl");
//		 org.hsqldb.util.DatabaseManagerSwing.main(new String[] { "--url",
//		 "jdbc:hsqldb:mem:embeddedDataSource", "--noexit"});

	}

	@Test
	public void create_and_getById_Test() {

		Project project = new Project();
		project.setName("one project");
		projectDao.create(project);
		Project stored = projectDao.getById((long) 4);
		assertEquals(project.getName(), stored.getName());

	}

	@Test
	public void getProjectsByCategory_Test() {
		Category category = new Category();
		category.setId((long) 5);
		List<Project> projects = projectDao.getProjectsByCategory(category);
		assertEquals("Create electrobike", projects.get(0).getName());
	}

}
