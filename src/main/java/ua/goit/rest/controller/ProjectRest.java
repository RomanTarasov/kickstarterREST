package ua.goit.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ua.goit.rest.dao.ProjectDao;
import ua.goit.rest.entity.Category;
import ua.goit.rest.entity.Project;

@RestController
@RequestMapping("/v1/project")
public class ProjectRest {

	@Autowired
	private ProjectDao projectDao;

	@RequestMapping(value = { "/get/id/{projectId}" }, method = RequestMethod.GET)
	@ResponseBody
	public Project getProjectById(@PathVariable Long projectId) {
		Project project = projectDao.getById(projectId);
		return project;
	}

	@RequestMapping(value = { "/get/categoryId/{categoryId}" }, method = RequestMethod.GET)
	@ResponseBody
	public List<Project> getProjectsByCategory(@PathVariable Long categoryId) {
		Category category = new Category();
		category.setId(categoryId);
		return projectDao.getProjectsByCategory(category);
	}
}
