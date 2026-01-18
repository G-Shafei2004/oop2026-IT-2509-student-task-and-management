package taskmanager.repositories;

import taskmanager.entities.Task;
import java.util.List;

public interface TaskRepository {
    void createTask(Task task);
    Task findTaskById(int id);
    List<Task> listAllTasks();
}
