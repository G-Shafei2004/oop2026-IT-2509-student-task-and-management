package taskmanager.repositories;

import taskmanager.entities.Comment;
import java.util.List;

public interface CommentRepository {
    void createComment(Comment comment);
    List<Comment> listCommentsByTaskId(int taskId);
}