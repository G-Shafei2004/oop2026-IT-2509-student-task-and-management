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

    // 1. PRIVATE CONSTRUCTOR
    // This is private so that the only way to create a Task is through the Builder.
    private Task(TaskBuilder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.status = builder.status;
        this.deadline = builder.deadline;
        this.projectId = builder.projectId;
        this.assignedUserId = builder.assignedUserId;
    }

    // 2. THE BUILDER CLASS (Static Inner Class)
    public static class TaskBuilder {
        private int id;
        private String title;
        private String status;
        private LocalDate deadline;
        private int projectId;
        private int assignedUserId;

        // Constructor for the Builder - Title is mandatory
        public TaskBuilder(String title) {
            this.title = title;
        }

        // Methods to set each field (They return 'this' to allow chaining)
        public TaskBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public TaskBuilder setStatus(String status) {
            this.status = status;
            return this;
        }

        public TaskBuilder setDeadline(LocalDate deadline) {
            this.deadline = deadline;
            return this;
        }

        public TaskBuilder setProjectId(int projectId) {
            this.projectId = projectId;
            return this;
        }

        public TaskBuilder setAssignedUserId(int assignedUserId) {
            this.assignedUserId = assignedUserId;
            return this;
        }

        // The final method that creates the actual Task object
        public Task build() {
            return new Task(this);
        }
    }

    // GETTERS (Keep these so you can read data)
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getStatus() { return status; }
    public LocalDate getDeadline() { return deadline; }
    public int getProjectId() { return projectId; }
    public int getAssignedUserId() { return assignedUserId; }

    // SETTERS (Optional: keep them if your database library needs them)
    public void setId(int id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setStatus(String status) { this.status = status; }
    public void setDeadline(LocalDate deadline) { this.deadline = deadline; }
    public void setProjectId(int projectId) { this.projectId = projectId; }
    public void setAssignedUserId(int assignedUserId) { this.assignedUserId = assignedUserId; }

    public long getDaysUntilDeadline() {
        if (this.deadline == null) return 0;
        return ChronoUnit.DAYS.between(LocalDate.now(), this.deadline);
    }
}