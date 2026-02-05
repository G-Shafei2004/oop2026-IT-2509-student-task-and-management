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
        userRepo.save(user);   // ✅ updated
    }

    public User getUserById(int id) {
        return userRepo.findById(id);   // ✅ updated
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();      // ✅ updated
    }

    public void deleteUser(int id) {
        userRepo.delete(id);            // ✅ optional but consistent
    }
}
