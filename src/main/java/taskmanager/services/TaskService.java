package taskmanager.services;

import taskmanager.entities.Task;
import taskmanager.repositories.TaskRepository;
import taskmanager.services.notification.NotificationFactory;
import taskmanager.services.notification.Notification;
import java.util.List;
import java.util.stream.Collectors;

public class TaskService {
    private final TaskRepository taskRepo;

    public TaskService(TaskRepository taskRepo) {
        this.taskRepo = taskRepo;
    }

    public void createTask(Task task) {
        if (task.getDeadline().isBefore(java.time.LocalDate.now())) {
            throw new RuntimeException("Deadline cannot be in the past!");
        }
        taskRepo.save(task);

        Notification messenger = NotificationFactory.getNotification("EMAIL");
        if (messenger != null) {
            messenger.send("Task '" + task.getTitle() + "' was successfully created!");
        }
    }

    public List<Task> getTasksByStatus(String status) {
        List<Task> allTasks = taskRepo.findAll();

        return allTasks.stream()
                .filter(t -> t.getStatus().equalsIgnoreCase(status))
                .collect(Collectors.toList());
    }

    public Task getTaskById(int id) {
        return taskRepo.findById(id);
    }

    public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }
}