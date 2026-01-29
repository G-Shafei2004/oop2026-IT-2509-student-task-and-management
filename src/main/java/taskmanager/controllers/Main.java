package taskmanager.controllers;

import taskmanager.entities.*;
import taskmanager.repositories.*;
import taskmanager.services.*;
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

        Scanner sc = new Scanner(System.in);

        try {
            System.out.println(" Starting Interactive Input ");
            String name;
            do {
                System.out.print("Enter user name: ");
                name = sc.nextLine().trim();
            } while (name.isEmpty());

            String email;
            do {
                System.out.print("Enter user email: ");
                email = sc.nextLine().trim();
            } while (email.isEmpty());

            String role;
            do {
                System.out.print("Enter user role (e.g., student, developer): ");
                role = sc.nextLine().trim();
            } while (role.isEmpty());

            User user = new User(0, name, email, role);
            userService.createUser(user);
            List<User> users = userService.getAllUsers();
            int userId = users.get(users.size() - 1).getId();
            System.out.println(" User created with ID: " + userId);



            String projectTitle;
            do {
                System.out.print("Enter project title: ");
                projectTitle = sc.nextLine().trim();
            } while (projectTitle.isEmpty());

            String projectDesc;
            do {
                System.out.print("Enter project description: ");
                projectDesc = sc.nextLine().trim();
            } while (projectDesc.isEmpty());

            Project project = new Project(0, projectTitle, projectDesc, userId);
            projectService.createProject(project);
            List<Project> projects = projectService.getAllProjects();
            int projectId = projects.get(projects.size() - 1).getId();
            System.out.println(" Project created with ID: " + projectId);



            String taskTitle;
            do {
                System.out.print("Enter task title: ");
                taskTitle = sc.nextLine().trim();
            } while (taskTitle.isEmpty());

            String taskStatus;
            do {
                System.out.print("Enter task status (e.g., Pending, Finished): ");
                taskStatus = sc.nextLine().trim();
            } while (taskStatus.isEmpty());

            LocalDate deadline = null;
            while (deadline == null) {
                System.out.print("Enter task deadline (YYYY-MM-DD): ");
                String deadlineInput = sc.nextLine().trim();
                try {
                    deadline = LocalDate.parse(deadlineInput);
                } catch (Exception e) {
                    System.out.println(" Invalid date format. Try again.");
                }
            }

            Task task = new Task(0, taskTitle, taskStatus, deadline, projectId, userId);
            taskService.createTask(task);
            System.out.println("Days remaining for this task: " + task.getDaysUntilDeadline());
            List<Task> tasks = taskService.getAllTasks();
            int taskId = tasks.get(tasks.size() - 1).getId();
            System.out.println(" Task created with ID: " + taskId);



            String commentText;
            do {
                System.out.print("Enter comment text: ");
                commentText = sc.nextLine().trim();
            } while (commentText.isEmpty());

            Comment comment = new Comment(0, commentText, taskId, userId, LocalDateTime.now());
            commentService.addComment(comment);
            System.out.println(" Comment added successfully");

        } catch (Exception e) {
            System.err.println(" Error: " + e.getMessage());
        }
    }
}
