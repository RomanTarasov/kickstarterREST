package ua.goit.rest.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.rest.entity.Category;
import ua.goit.rest.entity.Project;


@Component
@Transactional
public interface ProjectDao extends Dao<Project> {
	List<Project> getProjectsByCategory(Category category);

}
