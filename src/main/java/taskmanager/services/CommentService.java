package taskmanager.services;

import taskmanager.entities.Comment;
import taskmanager.repositories.CommentRepository;
import java.util.List;

public class CommentService {
    private final CommentRepository commentRepo;

    public CommentService(CommentRepository commentRepo) {
        this.commentRepo = commentRepo;
    }

    public void addComment(Comment comment) {
        if (comment.getText() == null || comment.getText().isEmpty()) {
            throw new RuntimeException("Comment text cannot be empty!");
        }
        commentRepo.createComment(comment);
    }

    public List<Comment> getCommentsForTask(int taskId) {
        return commentRepo.listCommentsByTaskId(taskId);
    }
}