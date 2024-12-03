package perscholas.stevealexbowman.cap312.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String home() {
        return "index"; // Maps to index.html in src/main/resources/templates
    }

    @GetMapping("/about")
    public String about() {
        return "about"; // Maps to about.html in src/main/resources/templates
    }

    @GetMapping("/subscribe")
    public String subscribe() {
        return "contact"; // Maps to contact.html in src/main/resources/templates
    }
}

