package taskmanager.entities;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Task {
    private int id;
    private String title;
    private String status;
    private LocalDate deadline;
    private int projectId;
    private int assignedUserId;

    public Task(int id, String title, String status, LocalDate deadline, int projectId, int assignedUserId) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.deadline = deadline;
        this.projectId = projectId;
        this.assignedUserId = assignedUserId;
    }


    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getStatus() { return status; }
    public LocalDate getDeadline() { return deadline; }
    public int getProjectId() { return projectId; }
    public int getAssignedUserId() { return assignedUserId; }


    public void setId(int id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setStatus(String status) { this.status = status; }
    public void setDeadline(LocalDate deadline) { this.deadline = deadline; }
    public void setProjectId(int projectId) { this.projectId = projectId; }
    public void setAssignedUserId(int assignedUserId) { this.assignedUserId = assignedUserId; }
    public long getDaysUntilDeadline() {
        if (this.deadline == null) {
            return 0;
        }
        return ChronoUnit.DAYS.between(LocalDate.now(), this.deadline);
    }
}