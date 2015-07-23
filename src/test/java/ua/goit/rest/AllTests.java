package ua.goit.rest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CategoryDaoTest.class, CommentDaoTest.class,
		ProjectDaoTest.class, QuoteDaoTest.class })
public class AllTests {

}
