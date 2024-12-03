package perscholas.stevealexbowman.cap312.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import perscholas.stevealexbowman.cap312.model.RecycleInventory;

public interface RecycleInventoryRepository extends JpaRepository<RecycleInventory, Long> {
}
