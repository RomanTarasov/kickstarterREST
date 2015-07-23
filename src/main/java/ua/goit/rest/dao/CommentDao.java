package ua.goit.rest.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Component;
import ua.goit.rest.entity.Comment;
import ua.goit.rest.entity.Project;

@Component
@Transactional
public interface CommentDao extends Dao<Comment> {
	List<Comment> getAllCommentsOfProject(Project project);
}
