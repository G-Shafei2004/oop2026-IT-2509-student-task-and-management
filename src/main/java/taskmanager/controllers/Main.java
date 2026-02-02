package taskmanager.controllers;

import taskmanager.entities.Task;
import taskmanager.repositories.TaskRepository;
import taskmanager.repositories.TaskRepositoryImpl;
import taskmanager.services.TaskService;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Initialize Repository and Service
        TaskRepository repository = new TaskRepositoryImpl();
        TaskService taskService = new TaskService(repository);

        System.out.println("--- Starting Milestone 2 Demo ---");

        // 2. DEMO: BUILDER PATTERN
        // We create a task without a long, confusing constructor.
        Task newTask = new Task.TaskBuilder("Study for Java Defense")
                .setStatus("Pending")
                .setDeadline(LocalDate.now().plusDays(5))
                .setProjectId(1)
                .setAssignedUserId(10)
                .build();

        System.out.println("Created Task via Builder: " + newTask.getTitle());

        // 3. DEMO: FACTORY PATTERN (Inside addNewTask)
        // When we call this, it saves to DB AND triggers the Notification Factory.
        taskService.addNewTask(newTask);

        // 4. DEMO: LAMBDAS & STREAMS
        // We filter the list of all tasks to find only 'Pending' ones using a Lambda.
        System.out.println("\n--- Filtering Tasks by Status (Lambda) ---");
        List<Task> pendingTasks = taskService.getTasksByStatus("Pending");

        pendingTasks.forEach(t ->
                System.out.println("Pending Task found: " + t.getTitle())
        );

        System.out.println("\n--- Milestone 2 Demo Completed Successfully ---");
    }
}