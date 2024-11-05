package myProject.SimpleCrudApp.Controller;


import myProject.SimpleCrudApp.Model.User;
import myProject.SimpleCrudApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/users")
public class MainController {

    @Autowired
    private UserService userService;

    // Show all users
    @GetMapping
    public String getAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "user-list"; // HTML page for listing users
    }

    // Show form to create a new user
    @GetMapping("/new")
    public String showCreateUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user-form"; // HTML page for creating a user
    }

    // Create a new user
    @PostMapping
    public String createUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users"; // Redirect to user list after creation
    }

    // Show form to edit an existing user
    @GetMapping("/edit/{id}")
    public String showEditUserForm(@PathVariable Long id, Model model) {
        Optional<User> user = userService.getUserById(id);
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
            return "user-form"; // HTML page for editing a user
        } else {
            return "redirect:/users"; // Redirect to user list if user not found
        }
    }

    // Update an existing user
    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute("user") User userDetails) {
        userService.updateUser(id, userDetails);
        return "redirect:/users"; // Redirect to user list after updating
    }

    // Delete a user
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/users"; // Redirect to user list after deletion
    }
}
