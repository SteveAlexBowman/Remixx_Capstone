package perscholas.stevealexbowman.cap312.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import perscholas.stevealexbowman.cap312.model.Pledge;

@Repository
public interface PledgeRepository extends JpaRepository<Pledge, Long> {
}
