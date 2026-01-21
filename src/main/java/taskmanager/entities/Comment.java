package taskmanager.entities;

import java.time.LocalDateTime;

public class Comment {
    private int id;
    private String text;
    private int taskId;
    private int userId;
    private LocalDateTime timestamp;

    public Comment(int id, String text, int taskId, int userId, LocalDateTime timestamp) {
        this.id = id;
        this.text = text;
        this.taskId = taskId;
        this.userId = userId;
        this.timestamp = timestamp;
    }

    // ✅ Add these getters
    public int getId() { return id; }
    public String getText() { return text; }
    public int getTaskId() { return taskId; }
    public int getUserId() { return userId; }
    public LocalDateTime getTimestamp() { return timestamp; }

    // Optional setters
    public void setId(int id) { this.id = id; }
    public void setText(String text) { this.text = text; }
    public void setTaskId(int taskId) { this.taskId = taskId; }
    public void setUserId(int userId) { this.userId = userId; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}