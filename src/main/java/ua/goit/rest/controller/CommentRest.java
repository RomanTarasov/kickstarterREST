package ua.goit.rest.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ua.goit.rest.dao.CommentDao;
import ua.goit.rest.entity.Comment;
import ua.goit.rest.entity.Project;

@RestController
@RequestMapping("/v1/comment")
public class CommentRest {
	@Autowired
	private CommentDao commentDao;

	@RequestMapping(value = { "/getAllCommentsByProjectId/{projectId}" }, method = RequestMethod.GET)
	@ResponseBody
	public List<Comment> getAllCommentsOfProject(@PathVariable Long projectId) {
		Project project = new Project();
		project.setId(projectId);
		return commentDao.getAllCommentsOfProject(project);
	}
}
