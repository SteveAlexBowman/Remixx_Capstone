package perscholas.stevealexbowman.cap312.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import perscholas.stevealexbowman.cap312.model.RecycleInventory;
import java.util.List;

public interface RecycleInventoryRepository extends JpaRepository<RecycleInventory, Long> {
    List<RecycleInventory> findByUserEmail(String email);
}
