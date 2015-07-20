package ua.goit.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ua.goit.rest.dao.CategoryDao;
import ua.goit.rest.dao.QuoteDao;
import ua.goit.rest.entity.Category;
import ua.goit.rest.entity.Quote;
import ua.goit.rest.page.MainPage;


@RestController
public class Main {

	@Autowired
	private QuoteDao quoteDao;

	@Autowired
	private CategoryDao categoryDao;

	@RequestMapping(value = {"/","/main"}, method = RequestMethod.GET)
	@ResponseBody
	public MainPage doGet(Model model) {
		MainPage mainPage=new MainPage();
		Quote randomQuote = quoteDao.getRandom();
		List<Category> categories = categoryDao.getAllCategories();
		mainPage.setRandomQuote(randomQuote);
		mainPage.setCategories(categories);
		return mainPage;
	}

}
