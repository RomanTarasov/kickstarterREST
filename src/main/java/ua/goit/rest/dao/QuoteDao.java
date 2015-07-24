package ua.goit.rest.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ua.goit.rest.entity.Quote;
@Component
@Transactional
public interface QuoteDao extends Dao<Quote>{

	Quote getRandom();

	List<Quote> getAllQuotes();
	

}
