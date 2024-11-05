package myProject.SimpleCrudApp.Service;

import myProject.SimpleCrudApp.Model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);
    Optional<User> getUserById(Long id);
    List<User> getAllUsers();
    Optional<User> updateUser(Long id, User userDetails);
    boolean deleteUser(Long id);
}
