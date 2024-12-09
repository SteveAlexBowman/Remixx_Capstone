package perscholas.stevealexbowman.cap312.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import perscholas.stevealexbowman.cap312.model.UserProfile;

import java.util.Optional;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

    // Find a user by email
    Optional<UserProfile> findByEmail(String email);

    // Check if a user exists by email
    boolean existsByEmail(String email);

}
