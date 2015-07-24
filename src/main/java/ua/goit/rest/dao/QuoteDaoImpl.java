package ua.goit.rest.dao;

import java.util.List;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.rest.entity.Quote;

@Transactional
public class QuoteDaoImpl extends AbstractDao<Quote> implements QuoteDao {

	QuoteDaoImpl() {
		super(Quote.class);
	}

	@Override
	public Quote getRandom() {
		Session currentSession = sessionFactory.getCurrentSession();
		return (Quote) currentSession
				.createSQLQuery("SELECT * FROM quotes ORDER BY RAND() LIMIT 1")
				.addEntity(Quote.class).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Quote> getAllQuotes() {
		return sessionFactory.getCurrentSession()
				.createCriteria(Quote.class).list();
	}
}
