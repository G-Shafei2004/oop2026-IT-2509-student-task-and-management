package taskmanager;

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

public class Main {
    public static void main(String[] args) {
        // Initialize services with repository implementations
        UserService userService = new UserService(new UserRepositoryImpl());
        ProjectService projectService = new ProjectService(new ProjectRepositoryImpl());
        TaskService taskService = new TaskService(new TaskRepositoryImpl());
        CommentService commentService = new CommentService(new CommentRepositoryImpl());

        // ✅ Test User
        User user = new User(0, "Ghulam", "ghulam@example.com", "student");
        userService.createUser(user);
        System.out.println("Users in DB:");
        for (User u : userService.getAllUsers()) {
            System.out.println(u.getId() + " - " + u.getName() + " (" + u.getEmail() + ")");
        }

        // ✅ Test Project
        Project project = new Project(0, "OOP Assignment", "Java + Supabase integration", 1);
        projectService.createProject(project);
        System.out.println("\nProjects in DB:");
        for (Project p : projectService.getAllProjects()) {
            System.out.println(p.getId() + " - " + p.getTitle());
        }

        // ✅ Test Task
        Task task = new Task(0, "Finish Repository Layer", "Pending", LocalDate.of(2026, 1, 25), 1, 1);
        taskService.createTask(task);
        System.out.println("\nTasks in DB:");
        for (Task t : taskService.getAllTasks()) {
            System.out.println(t.getId() + " - " + t.getTitle() + " [" + t.getStatus() + "]");
        }

        // ✅ Test Comment
        Comment comment = new Comment(0, "This task is almost done!", 1, 1, LocalDateTime.now());
        commentService.addComment(comment);
        System.out.println("\nComments for Task 1:");
        for (Comment c : commentService.getCommentsForTask(1)) {
            System.out.println(c.getId() + " - " + c.getText() + " (by user " + c.getUserId() + ")");
        }
    }
}
