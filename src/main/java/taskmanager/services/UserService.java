package taskmanager.services;

import taskmanager.entities.User;
import taskmanager.repositories.UserRepository;
import java.util.List;

public class UserService {
    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public void createUser(User user) {
        if (user.getEmail() == null || !user.getEmail().contains("@")) {
            throw new RuntimeException("Invalid email address!");
        }
        userRepo.createUser(user);
    }

    public User getUserById(int id) {
        return userRepo.findUserById(id);
    }

    public List<User> getAllUsers() {
        return userRepo.listAllUsers();
    }
}
