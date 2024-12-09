package perscholas.stevealexbowman.cap312.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import perscholas.stevealexbowman.cap312.model.RecycleInventory;
import perscholas.stevealexbowman.cap312.model.UserProfile;
import perscholas.stevealexbowman.cap312.service.RecycleInventoryService;
import perscholas.stevealexbowman.cap312.service.UserProfileService;

import java.util.List;


/*
    Class handling HTTP requests for managing recycling inventory
 */

@Controller
public class RecycleController {
    @Autowired
    private RecycleInventoryService recycleInventoryService;

    @Autowired
    private UserProfileService userProfileService;

    @GetMapping("/recycle")
    // @AuthenticationPrincipal -- retrieving the authenticated user's details
    public String viewRecyclePage(Model model, @AuthenticationPrincipal org.springframework.security.core.userdetails.User user) {
        String email = user.getUsername();
        // Fetching the recycling inventory associated with the logged-in user
        List<RecycleInventory> inventory = recycleInventoryService.getInventoryByUserEmail(email);
        model.addAttribute("inventory", inventory);
        return "recycle";
    }

    @PostMapping("/recycle/add")
    public String addRecycleItem(
            @RequestParam String materialType,
            @RequestParam Integer quantity,
            @AuthenticationPrincipal org.springframework.security.core.userdetails.User user
    ) {
        // Retrieve email from the authenticated user
        String email = user.getUsername();

        // Fetch the UserProfile based on the email using findByEmail method from UserProfileService
        UserProfile userProfile = userProfileService.findByEmail(email);

        // Create a new RecycleInventory object
        RecycleInventory inventory = new RecycleInventory();
        inventory.setMaterialType(materialType);
        inventory.setQuantity(quantity);

        // Associate the inventory with the user
        inventory.setUser(userProfile);

        // Save the inventory
        recycleInventoryService.saveInventory(inventory);

        return "redirect:/recycle";
    }

    // Delete inventory item
    @DeleteMapping("/recycle/delete/{id}")
    public ResponseEntity<String> deleteInventory(@PathVariable Long id) {
        try {
            recycleInventoryService.deleteInventoryById(id); // Use the correct service
            return ResponseEntity.ok("Inventory deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error deleting inventory: " + e.getMessage());
        }
    }

    // Update inventory item
    @PutMapping("/recycle/update/{id}")
    public ResponseEntity<String> updateInventory(
            @PathVariable Long id,
            @RequestParam String materialType,
            @RequestParam Integer quantity
    ) {
        try {
            recycleInventoryService.updateInventoryById(id, materialType, quantity); // Implement this in the service
            return ResponseEntity.ok("Inventory updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error updating inventory: " + e.getMessage());
        }
    }

}
