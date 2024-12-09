package perscholas.stevealexbowman.cap312.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import perscholas.stevealexbowman.cap312.model.RecycleInventory;
import perscholas.stevealexbowman.cap312.repository.RecycleInventoryRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class RecycleInventoryServiceTest {

    @Mock
    private RecycleInventoryRepository recycleInventoryRepository;

    @InjectMocks
    private RecycleInventoryService recycleInventoryService;

    @Test
    public void testUpdateInventory() {
        Long inventoryId = 1L;
        String newMaterialType = "Glass";
        int newQuantity = 20;

        RecycleInventory inventory = new RecycleInventory();
        inventory.setId(inventoryId);
        inventory.setMaterialType("Plastic");
        inventory.setQuantity(10);

        when(recycleInventoryRepository.findById(inventoryId)).thenReturn(Optional.of(inventory));

        recycleInventoryService.updateInventoryById(inventoryId, newMaterialType, newQuantity);

        assertEquals("Glass", inventory.getMaterialType());
        assertEquals(20, inventory.getQuantity());
        verify(recycleInventoryRepository).save(inventory);
    }
}

