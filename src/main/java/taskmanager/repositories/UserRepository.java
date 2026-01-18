package taskmanager.repositories;

import taskmanager.entities.User;
import java.util.List;

public interface UserRepository {
    void createUser(User user);
    User findUserById(int id);
    List<User> listAllUsers();
}
