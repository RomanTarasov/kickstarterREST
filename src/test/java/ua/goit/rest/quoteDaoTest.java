package ua.goit.rest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.goit.rest.dao.QuoteDao;
import ua.goit.rest.entity.Quote;


public class quoteDaoTest {


	ApplicationContext app;
	QuoteDao quoteDao;

	@Before
	public void setUp() {
		app = new ClassPathXmlApplicationContext("root-context.xml");
		quoteDao = (QuoteDao) app.getBean("quoteDaoImpl");
//		 org.hsqldb.util.DatabaseManagerSwing.main(new String[] { "--url",
//				 "jdbc:hsqldb:mem:embeddedDataSource", "--noexit"});
	}
	@Test
	public void test() {
		Quote randomQuote = quoteDao.getRandom();
		assertNotNull(randomQuote);
	}

}
