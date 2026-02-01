package taskmanager.repositories;

import taskmanager.entities.Task;

// We extend ICrudRepository and tell it we are working with <Task>
public interface TaskRepository extends ICrudRepository<Task> {
    // You can add extra methods here if they are only for Tasks
}