package taskmanager.controllers;

import taskmanager.entities.Task;
import taskmanager.entities.User;
import taskmanager.repositories.TaskRepositoryImpl;
import taskmanager.repositories.UserRepositoryImpl;
import taskmanager.services.TaskService;
import taskmanager.services.UserService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        UserService userService = new UserService(new UserRepositoryImpl());
        TaskService taskService = new TaskService(new TaskRepositoryImpl());
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

            // -------- TASK INPUT --------
            System.out.print("Enter project ID: ");
            int projectId = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter task title: ");
            String taskTitle = scanner.nextLine();

            // -------- BUILDER PATTERN --------
            Task task = new Task.TaskBuilder(taskTitle)
                    .setStatus("Pending")
                    .setDeadline(LocalDate.now().plusDays(7))
                    .setProjectId(projectId)
                    .setAssignedUserId(userId)
                    .build();

            // -------- FACTORY (inside service) --------
            taskService.addNewTask(task);

            // -------- LAMBDA / STREAMS --------
            System.out.println("\n--- Pending Tasks ---");
            taskService.getTasksByStatus("Pending")
                    .forEach(t ->
                            System.out.println("User: " + name + " | Task: " + t.getTitle())
                    );

            System.out.println("\nData saved successfully!");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
