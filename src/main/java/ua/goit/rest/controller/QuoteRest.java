package ua.goit.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ua.goit.rest.dao.QuoteDao;
import ua.goit.rest.entity.Quote;

@RestController
@RequestMapping("/v1/quote")
public class QuoteRest {

	@Autowired
	private QuoteDao quoteDao;

	@RequestMapping(value = { "/getRandom" }, method = RequestMethod.GET)
	@ResponseBody
	public Quote getRandom() {
		Quote quote = quoteDao.getRandom();
		return quote;
	}
}
