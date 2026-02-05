package taskmanager.repositories;

import taskmanager.entities.Task;
import taskmanager.entities.User;
import java.util.List;

public interface UserRepository extends ICrudRepository<User> {
    // You can add extra methods here if they are only for Tasks
}