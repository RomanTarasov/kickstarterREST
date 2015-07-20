package ua.goit.rest.page;

import java.util.List;

import ua.goit.rest.entity.Category;
import ua.goit.rest.entity.Quote;

public class MainPage {
	private Quote randomQuote;
	public Quote getRandomQuote() {
		return randomQuote;
	}
	public void setRandomQuote(Quote randomQuote) {
		this.randomQuote = randomQuote;
	}
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	private List<Category> categories;
}
