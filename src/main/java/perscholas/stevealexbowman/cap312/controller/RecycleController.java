package perscholas.stevealexbowman.cap312.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import perscholas.stevealexbowman.cap312.model.RecycleInventory;
import perscholas.stevealexbowman.cap312.service.RecycleInventoryService;

@Controller
public class RecycleController {

    @Autowired
    private RecycleInventoryService service;

    @GetMapping("/recycle")
    public String viewRecyclePage(Model model) {
        model.addAttribute("inventory", service.getAllInventory());
        return "recycle";
    }

    @PostMapping("/recycle/add")
    public String addInventory(@RequestParam String materialType,
                               @RequestParam Integer quantity) {
        RecycleInventory inventory = new RecycleInventory();
        inventory.setMaterialType(materialType);
        inventory.setQuantity(quantity);
        service.saveInventory(inventory);
        return "redirect:/recycle";
    }
}
