package taskmanager.repositories;

import taskmanager.db.DatabaseConnection;
import taskmanager.entities.Task;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskRepositoryImpl implements TaskRepository {

    @Override
    public void save(Task task) {
        String sql = "INSERT INTO tasks (title, status, deadline, project_id, assigned_user_id) VALUES (?, ?, ?, ?, ?)";
        // Reusing the same connection via Singleton
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, task.getTitle());
            stmt.setString(2, task.getStatus());
            stmt.setDate(3, java.sql.Date.valueOf(task.getDeadline()));
            stmt.setInt(4, task.getProjectId());
            stmt.setInt(5, task.getAssignedUserId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Task findById(int id) {
        String sql = "SELECT * FROM tasks WHERE id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Task(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("status"),
                        rs.getDate("deadline").toLocalDate(),
                        rs.getInt("project_id"),
                        rs.getInt("assigned_user_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Task> findAll() {
        List<Task> tasks = new ArrayList<>();
        String sql = "SELECT * FROM tasks";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                tasks.add(new Task(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("status"),
                        rs.getDate("deadline").toLocalDate(),
                        rs.getInt("project_id"),
                        rs.getInt("assigned_user_id")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    // ADD THIS TO REMOVE THE ERROR
    @Override
    public void delete(int id) {
        String sql = "DELETE FROM tasks WHERE id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}