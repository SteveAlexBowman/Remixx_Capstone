package perscholas.stevealexbowman.cap312.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import perscholas.stevealexbowman.cap312.model.RecycleInventory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class RecycleInventoryRepositoryTest {

    @Autowired
    private RecycleInventoryRepository recycleInventoryRepository;

    @Test
    public void testSaveInventory() {
        RecycleInventory inventory = new RecycleInventory();
        inventory.setMaterialType("Plastic");
        inventory.setQuantity(10);
        recycleInventoryRepository.save(inventory);

        List<RecycleInventory> inventories = recycleInventoryRepository.findAll();
        assertEquals(1, inventories.size());
        assertEquals("Plastic", inventories.get(0).getMaterialType());
    }
}

