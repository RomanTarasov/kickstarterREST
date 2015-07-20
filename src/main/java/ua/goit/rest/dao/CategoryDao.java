package ua.goit.rest.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import ua.goit.rest.entity.Category;


@Component
@Transactional
public interface CategoryDao extends Dao<Category> {
	List<Category> getAllCategories();
}
