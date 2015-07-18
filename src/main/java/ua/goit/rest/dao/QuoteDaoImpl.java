package ua.goit.rest.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.rest.entity.Quote;

@Component
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
}
