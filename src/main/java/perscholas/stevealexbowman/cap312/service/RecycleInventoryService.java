package perscholas.stevealexbowman.cap312.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import perscholas.stevealexbowman.cap312.model.RecycleInventory;
import perscholas.stevealexbowman.cap312.repository.RecycleInventoryRepository;

import java.util.List;

@Service //Marking the class as a service, making it a spring-managed bean
public class RecycleInventoryService {
    @Autowired // Automatically handling DI
    private RecycleInventoryRepository recycleInventoryRepository;

    public List<RecycleInventory> getInventoryByUserEmail(String email) {
        return recycleInventoryRepository.findByUserEmail(email);
    }

    // Method to save inventory
    public void saveInventory(RecycleInventory inventory) {
        // Saving the given inventory to the database
        recycleInventoryRepository.save(inventory);
    }
    // Method to delete inventory by ID
    public void deleteInventoryById(Long id) {
        recycleInventoryRepository.deleteById(id);
    }
    // Method to update inventory by ID
    public void updateInventoryById(Long id, String materialType, Integer quantity) {
        RecycleInventory inventory = recycleInventoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inventory not found with ID: " + id));

        // Update fields
        inventory.setMaterialType(materialType);
        inventory.setQuantity(quantity);

        // Save updated entity back to the database
        recycleInventoryRepository.save(inventory);
    }
}
