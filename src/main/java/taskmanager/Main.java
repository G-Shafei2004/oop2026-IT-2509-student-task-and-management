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
            System.out.println("--- Starting Fresh Database Test with 3 Users ---");

            // ==========================
            // User 1
            User user1 = new User(0, "Sara", "sara.team@example.com", "developer");
            userService.createUser(user1);
            List<User> users1 = userService.getAllUsers();
            int userId1 = users1.get(users1.size() - 1).getId();
            System.out.println("User 1 Created (ID: " + userId1 + ")");

            Project project1 = new Project(0, "Frontend Redesign", "Redesign website UI", userId1);
            projectService.createProject(project1);
            List<Project> projects1 = projectService.getAllProjects();
            int projectId1 = projects1.get(projects1.size() - 1).getId();
            System.out.println("Project 1 Created (ID: " + projectId1 + ")");

            Task task1 = new Task(0, "Redesign Landing Page", "Pending",
                    LocalDate.of(2026, 3, 5), projectId1, userId1);
            taskService.createTask(task1);
            List<Task> tasks1 = taskService.getAllTasks();
            int taskId1 = tasks1.get(tasks1.size() - 1).getId();
            System.out.println("Task 1 Created (ID: " + taskId1 + ")");

            Comment comment1 = new Comment(0, "Started redesigning landing page.", taskId1, userId1, LocalDateTime.now());
            commentService.addComment(comment1);
            System.out.println("Comment 1 Created!");

            // ==========================
            // User 2
            User user2 = new User(0, "Omar", "omar.manager@example.com", "manager");
            userService.createUser(user2);
            List<User> users2 = userService.getAllUsers();
            int userId2 = users2.get(users2.size() - 1).getId();
            System.out.println("User 2 Created (ID: " + userId2 + ")");

            Project project2 = new Project(0, "API Development", "Develop REST APIs", userId2);
            projectService.createProject(project2);
            List<Project> projects2 = projectService.getAllProjects();
            int projectId2 = projects2.get(projects2.size() - 1).getId();
            System.out.println("Project 2 Created (ID: " + projectId2 + ")");

            Task task2 = new Task(0, "Create User API", "In Progress",
                    LocalDate.of(2026, 3, 10), projectId2, userId2);
            taskService.createTask(task2);
            List<Task> tasks2 = taskService.getAllTasks();
            int taskId2 = tasks2.get(tasks2.size() - 1).getId();
            System.out.println("Task 2 Created (ID: " + taskId2 + ")");

            Comment comment2 = new Comment(0, "User API endpoints created.", taskId2, userId2, LocalDateTime.now());
            commentService.addComment(comment2);
            System.out.println("Comment 2 Created!");

            // ==========================
            // User 3
            User user3 = new User(0, "Leila", "leila.qa@example.com", "tester");
            userService.createUser(user3);
            List<User> users3 = userService.getAllUsers();
            int userId3 = users3.get(users3.size() - 1).getId();
            System.out.println("User 3 Created (ID: " + userId3 + ")");

            Project project3 = new Project(0, "Testing Suite", "Create automated tests", userId3);
            projectService.createProject(project3);
            List<Project> projects3 = projectService.getAllProjects();
            int projectId3 = projects3.get(projects3.size() - 1).getId();
            System.out.println("Project 3 Created (ID: " + projectId3 + ")");

            Task task3 = new Task(0, "Write Test Cases", "Pending",
                    LocalDate.of(2026, 3, 15), projectId3, userId3);
            taskService.createTask(task3);
            List<Task> tasks3 = taskService.getAllTasks();
            int taskId3 = tasks3.get(tasks3.size() - 1).getId();
            System.out.println("Task 3 Created (ID: " + taskId3 + ")");

            Comment comment3 = new Comment(0, "Preparing initial test cases.", taskId3, userId3, LocalDateTime.now());
            commentService.addComment(comment3);
            System.out.println("Comment 3 Created!");

            System.out.println("\n--- SUCCESS! 3 Users, Projects, Tasks, Comments Created ---");

        } catch (Exception e) {
            System.err.println("❌ Error: " + e.getMessage());
        }
    }
}
