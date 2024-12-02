package perscholas.stevealexbowman.cap312.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String home() {
        return "index"; // Maps to a Thymeleaf template named 'index.html'
    }
}
