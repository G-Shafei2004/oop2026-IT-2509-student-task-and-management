package taskmanager.services;
import taskmanager.services.notification.INotification;
import taskmanager.entities.Task;
import taskmanager.repositories.TaskRepository;
import taskmanager.services.notification.INotification;
import taskmanager.services.notification.NotificationFactory;

import java.util.List;
import java.util.stream.Collectors;

public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // This method triggers the Factory Pattern (New Scenario)
    public void addNewTask(Task task) {
        taskRepository.save(task);

        // Factory Pattern in action
        INotification notification = NotificationFactory.getNotification("EMAIL");
        if (notification != null) {
            notification.send("New task assigned: " + task.getTitle());
        }
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // This method satisfies the Lambdas & Streams requirement
    public List<Task> getTasksByStatus(String status) {
        return taskRepository.findAll().stream()
                .filter(t -> t.getStatus().equalsIgnoreCase(status))
                .collect(Collectors.toList());
    }
}