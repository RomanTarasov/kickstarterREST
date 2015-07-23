package ua.goit.rest;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.goit.rest.dao.CategoryDao;
import ua.goit.rest.entity.Category;



public class CategoryDaoTest {

	ApplicationContext app;
	CategoryDao categoryDao;

	@Before
	public void setUp() {
		app = new ClassPathXmlApplicationContext("root-context.xml");
		categoryDao = (CategoryDao) app.getBean("categoryDaoImpl");
//		 org.hsqldb.util.DatabaseManagerSwing.main(new String[] { "--url",
//		 "jdbc:hsqldb:mem:embeddedDataSource", "--noexit"});

	}

	@Test
	public void create_and_getById_Test() {

		Category category = new Category();
		category.setName("one category");
		category.setId((long) 90);
		categoryDao.create(category);
		Category stored = categoryDao.getById((long) 6);
		assertEquals(category.getName(), stored.getName());

	}

	@Test
	public void getAllCategories_Test() {
		Category category = new Category();
		category.setName("two category");
		category.setId((long) 91);
		categoryDao.create(category);
		List<Category> categories = categoryDao.getAllCategories();
		assertEquals("two category",categories.get(2).getName());
	}

}
