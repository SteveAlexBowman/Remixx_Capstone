package perscholas.stevealexbowman.cap312.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import perscholas.stevealexbowman.cap312.model.Subscriber;
import perscholas.stevealexbowman.cap312.service.SubscriberService;

@Controller
public class ContactController {

    @Autowired
    private SubscriberService subscriberService;

    @GetMapping("/subscribe")
    public String showSubscribePage(Model model) {
        model.addAttribute("subscribers", subscriberService.getAllSubscribers());
        return "contact";
    }

    @PostMapping("/subscribe/add")
    public String addSubscriber(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String message
    ) {
        Subscriber subscriber = new Subscriber();
        subscriber.setName(name);
        subscriber.setEmail(email);
        subscriber.setMessage(message);
        subscriberService.saveSubscriber(subscriber);
        return "redirect:/subscribe";
    }
}
