
package taskmanager.services;

import taskmanager.entities.Task;
import taskmanager.repositories.TaskRepository;
import java.util.List;

public class TaskService {
    private final TaskRepository taskRepo;

    public TaskService(TaskRepository taskRepo) {
        this.taskRepo = taskRepo;
    }

    public void createTask(Task task) {
        if (task.getDeadline().isBefore(java.time.LocalDate.now())) {
            throw new RuntimeException("Deadline cannot be in the past!");
        }
        taskRepo.createTask(task);
    }


    public Task getTaskById(int id) {
        return taskRepo.findTaskById(id);
    }

    public List<Task> getAllTasks() {
        return taskRepo.listAllTasks();
    }
}
