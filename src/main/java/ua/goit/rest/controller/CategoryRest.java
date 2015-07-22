package ua.goit.rest.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ua.goit.rest.dao.CategoryDao;
import ua.goit.rest.entity.Category;

@RestController
@RequestMapping("/v1/category")
public class CategoryRest {

	@Autowired
	private CategoryDao categoryDao;

	@RequestMapping(value = { "/getAll" }, method = RequestMethod.GET)
	@ResponseBody
	public List<Category> getAllCategories() {
		List<Category> categories = categoryDao.getAllCategories();
		return categories;
	}
}