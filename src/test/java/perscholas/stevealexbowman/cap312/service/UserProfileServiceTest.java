package perscholas.stevealexbowman.cap312.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import perscholas.stevealexbowman.cap312.model.UserProfile;
import perscholas.stevealexbowman.cap312.repository.UserProfileRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserProfileServiceTest {

    @Mock
    private UserProfileRepository userProfileRepository;

    @InjectMocks
    private UserProfileService userProfileService;

    @Test
    public void testRegisterUser() {
        // Arrange
        UserProfile user = new UserProfile();
        user.setName("Test User");
        user.setEmail("test@example.com");
        user.setPassword("password123");

        when(userProfileRepository.existsByEmail("test@example.com")).thenReturn(false);
        when(userProfileRepository.save(any(UserProfile.class))).thenReturn(user);

        // Act
        UserProfile registeredUser = userProfileService.registerUser(user);

        // Assert
        assertNotNull(registeredUser);
        assertEquals("Test User", registeredUser.getName());
        assertEquals("test@example.com", registeredUser.getEmail());
    }
}
