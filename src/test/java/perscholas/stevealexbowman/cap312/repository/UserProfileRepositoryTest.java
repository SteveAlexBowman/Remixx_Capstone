package perscholas.stevealexbowman.cap312.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import perscholas.stevealexbowman.cap312.model.UserProfile;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class UserProfileRepositoryTest {

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Test
    public void testSaveUserProfile() {
        UserProfile user = new UserProfile();
        user.setName("Test User");
        user.setEmail("test@example.com");
        user.setPassword("password123");
        userProfileRepository.save(user);

        Optional<UserProfile> foundUser = userProfileRepository.findByEmail("test@example.com");
        assertTrue(foundUser.isPresent());
        assertEquals("Test User", foundUser.get().getName());
    }
}
