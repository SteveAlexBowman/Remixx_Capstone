package perscholas.stevealexbowman.cap312.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import perscholas.stevealexbowman.cap312.model.UserProfile;
import perscholas.stevealexbowman.cap312.service.UserProfileService;

import java.util.List;

@Controller
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    // View all users
    @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("users", userProfileService.getAllUsers());
        return "users";
    }


    // Add a new user
    @PostMapping("/users/add")
    public String addUser(
            @RequestParam String name,
            @RequestParam String email,
            Model model
    ) {
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);

        UserProfile user = new UserProfile();
        user.setName(name);
        user.setEmail(email);
        try {
            userProfileService.saveUser(user);
        } catch (Exception e) {
            model.addAttribute("error", "Error saving user: " + e.getMessage());
            return "users";
        }

        return "redirect:/users";
    }
    @PostMapping("/register")
    public String registerUser(@ModelAttribute UserProfile userProfile, Model model) {
        try {
            userProfileService.registerUser(userProfile);
            model.addAttribute("success", "Registration successful! Please log in.");
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
        }
        return "login"; // Redirect to register.html or login.html
    }
    @GetMapping("/register")
    public String showRegisterPage() {
        return "register"; // Matches register.html in the templates folder
    }


}
