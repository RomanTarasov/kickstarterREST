package ua.goit.rest.dao;

import ua.goit.rest.entity.Quote;

public interface QuoteDao extends Dao<Quote>{

	Quote getRandom();

}
