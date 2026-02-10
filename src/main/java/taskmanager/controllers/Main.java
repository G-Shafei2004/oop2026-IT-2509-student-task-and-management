package taskmanager.controllers;

import taskmanager.entities.User;
import taskmanager.entities.Project;
import taskmanager.entities.Task;
import taskmanager.entities.Comment;

import taskmanager.repositories.UserRepositoryImpl;
import taskmanager.repositories.ProjectRepositoryImpl;
import taskmanager.repositories.TaskRepositoryImpl;
import taskmanager.repositories.CommentRepositoryImpl;

import taskmanager.services.UserService;
import taskmanager.services.ProjectService;
import taskmanager.services.TaskService;
import taskmanager.services.CommentService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        UserService userService = new UserService(new UserRepositoryImpl());
        ProjectService projectService = new ProjectService(new ProjectRepositoryImpl());
        TaskService taskService = new TaskService(new TaskRepositoryImpl());
        CommentService commentService = new CommentService(new CommentRepositoryImpl());

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("=== Task Manager System | Milestone 2 ===");

            // -------- USER INPUT --------
            System.out.print("Enter user name: ");
            String name = scanner.nextLine();

            System.out.print("Enter user email: ");
            String email = scanner.nextLine();

            System.out.print("Enter user role: ");
            String role = scanner.nextLine();

            userService.createUser(new User(0, name, email, role));

            // get last inserted user (demo purpose)
            List<User> users = userService.getAllUsers();
            int userId = users.get(users.size() - 1).getId();

            // -------- PROJECT INPUT (NAME, not ID) --------
            System.out.print("Enter project name: ");
            String projectName = scanner.nextLine();

            // ✅ FIX: pass ownerId=userId to satisfy FK projects.owner_id -> users.id
            projectService.createProject(new Project(0, projectName, null, userId));

            // get last inserted project (demo purpose)
            List<Project> projects = projectService.getAllProjects();
            int projectId = projects.get(projects.size() - 1).getId();

            // -------- TASK INPUT --------
            System.out.print("Enter task title: ");
            String taskTitle = scanner.nextLine();

            // status choice (human-friendly)
            System.out.print("Enter task status (1=Pending, 2=Finished): ");
            String statusChoice = scanner.nextLine().trim();
            String status = statusChoice.equals("2") ? "Finished" : "Pending";

            // optional: ask deadline days (keep simple; press Enter -> 7 days)
            System.out.print("Enter deadline in days (press Enter for 7): ");
            String daysInput = scanner.nextLine().trim();
            int days = daysInput.isEmpty() ? 7 : Integer.parseInt(daysInput);

            // -------- BUILDER PATTERN --------
            Task task = new Task.TaskBuilder(taskTitle)
                    .setStatus(status)
                    .setDeadline(LocalDate.now().plusDays(days))
                    .setProjectId(projectId)
                    .setAssignedUserId(userId)
                    .build();

            // -------- SAVE TASK (FACTORY/NOTIFICATION can happen inside service) --------
            taskService.addNewTask(task);

            // get last inserted task id (demo purpose)
            List<Task> allTasks = taskService.getAllTasks(); // must exist in your TaskService
            int taskId = allTasks.get(allTasks.size() - 1).getId();

            // -------- COMMENT INPUT --------
            System.out.print("Enter a comment for this task: ");
            String commentText = scanner.nextLine();

            Comment comment = new Comment(
                    0,
                    commentText,
                    taskId,
                    userId,
                    LocalDateTime.now()
            );

            commentService.addComment(comment);

            // -------- DISPLAY RESULT --------
            System.out.println("\n--- Created Summary ---");
            System.out.println("User: " + name + " (" + role + ")");
            System.out.println("Project: " + projectName + " [id=" + projectId + "]");
            System.out.println("Task: " + taskTitle + " | Status: " + status + " | Deadline: " + LocalDate.now().plusDays(days));
            System.out.println("Comment: " + commentText);

            // -------- LAMBDA / STREAMS: show tasks by status --------
            System.out.println("\n--- Tasks with status: " + status + " ---");
            taskService.getTasksByStatus(status)
                    .forEach(t -> System.out.println("Task: " + t.getTitle() + " | ProjectId: " + t.getProjectId()));

            System.out.println("\nData saved successfully!");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
