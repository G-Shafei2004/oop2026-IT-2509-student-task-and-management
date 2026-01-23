package taskmanager;

import taskmanager.entities.*;
import taskmanager.repositories.*;
import taskmanager.services.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService(new UserRepositoryImpl());
        ProjectService projectService = new ProjectService(new ProjectRepositoryImpl());
        TaskService taskService = new TaskService(new TaskRepositoryImpl());
        CommentService commentService = new CommentService(new CommentRepositoryImpl());

        try {
            System.out.println("--- ✅Starting ---");

            // ==========================
            // User 1
            User user1 = new User(0, "Madi", "mahdi.@xample.com", "developer");
            userService.createUser(user1);
            List<User> users1 = userService.getAllUsers();
            int userId1 = users1.get(users1.size() - 1).getId();
            System.out.println("✅User Created successfully (ID: " + userId1 + ")");

            Project project1 = new Project(0, "Assembly Assignment", "Completing all Labs", userId1);
            projectService.createProject(project1);
            List<Project> projects1 = projectService.getAllProjects();
            int projectId1 = projects1.get(projects1.size() - 1).getId();
            System.out.println("✅Project Created successfully (ID: " + projectId1 + ")");

            Task task1 = new Task(0, "Done second lab", "Finished",
                    LocalDate.of(2026, 3, 5), projectId1, userId1);
            taskService.createTask(task1);
            List<Task> tasks1 = taskService.getAllTasks();
            int taskId1 = tasks1.get(tasks1.size() - 1).getId();
            System.out.println("✅Task Created successfully (ID: " + taskId1 + ")");

            Comment comment1 = new Comment(0, "Already started.", taskId1, userId1, LocalDateTime.now());
            commentService.addComment(comment1);
            System.out.println("✅Comment Created successfully ");

        } catch (Exception e) {
            System.err.println("❌ Error: " + e.getMessage());
        }
    }
}
