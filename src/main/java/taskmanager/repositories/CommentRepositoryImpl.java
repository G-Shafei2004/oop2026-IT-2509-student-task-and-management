package taskmanager.repositories;

import taskmanager.db.DatabaseConnection;
import taskmanager.entities.Comment;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CommentRepositoryImpl implements CommentRepository {
    @Override
    public void createComment(Comment comment) {
        String sql = "INSERT INTO comments (text, task_id, user_id, timestamp) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, comment.getText());
            stmt.setInt(2, comment.getTaskId());
            stmt.setInt(3, comment.getUserId());
            stmt.setTimestamp(4, Timestamp.valueOf(comment.getTimestamp()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Comment> listCommentsByTaskId(int taskId) {
        List<Comment> comments = new ArrayList<>();
        String sql = "SELECT * FROM comments WHERE task_id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, taskId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                comments.add(new Comment(
                        rs.getInt("id"),
                        rs.getString("text"),
                        rs.getInt("task_id"),
                        rs.getInt("user_id"),
                        rs.getTimestamp("timestamp").toLocalDateTime()
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comments;
    }
}