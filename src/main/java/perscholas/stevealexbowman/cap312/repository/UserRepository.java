package perscholas.stevealexbowman.cap312.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import perscholas.stevealexbowman.cap312.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
