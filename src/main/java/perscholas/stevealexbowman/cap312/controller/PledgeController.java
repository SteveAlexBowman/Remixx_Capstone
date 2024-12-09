package perscholas.stevealexbowman.cap312.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import perscholas.stevealexbowman.cap312.model.Pledge;
import perscholas.stevealexbowman.cap312.service.PledgeService;

@Controller
public class PledgeController {

    @Autowired
    private PledgeService pledgeService;

    // Update this route to avoid conflict
    @GetMapping("/about/pledge")
    public String viewPledgePage(Model model) {
        model.addAttribute("pledges", pledgeService.getAllPledges());
        return "about";
    }

    // The form action from about.html matches this route
    @PostMapping("/about/pledge/submit")
    public String submitPledge(
            @RequestParam String name,
            @RequestParam String state,
            @RequestParam boolean pledge,
            @RequestParam("recycling-level") String recyclingLevel
    ) {
        Pledge newPledge = new Pledge();
        newPledge.setName(name);
        newPledge.setState(state);
        newPledge.setPledge(pledge);
        newPledge.setRecyclingLevel(recyclingLevel);

        // Save the pledge to the database
        pledgeService.savePledge(newPledge);

        // Redirect back to the pledge page
        return "redirect:/about/pledge";
    }

}
