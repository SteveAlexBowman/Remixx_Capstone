package perscholas.stevealexbowman.cap312.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import perscholas.stevealexbowman.cap312.model.RecycleInventory;
import perscholas.stevealexbowman.cap312.repository.RecycleInventoryRepository;

import java.util.List;

@Service
public class RecycleInventoryService {

    @Autowired
    private RecycleInventoryRepository repository;

    public List<RecycleInventory> getAllInventory() {
        return repository.findAll();
    }

    public RecycleInventory saveInventory(RecycleInventory inventory) {
        return repository.save(inventory);
    }
}
