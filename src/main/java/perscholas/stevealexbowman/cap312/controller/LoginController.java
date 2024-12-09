package perscholas.stevealexbowman.cap312.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login() {
        return "login"; // Thymeleaf will look for login.html in src/main/resources/templates
    }
}
