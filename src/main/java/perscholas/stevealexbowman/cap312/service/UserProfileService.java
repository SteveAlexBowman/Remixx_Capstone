package perscholas.stevealexbowman.cap312.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import perscholas.stevealexbowman.cap312.model.UserProfile;
import perscholas.stevealexbowman.cap312.repository.UserProfileRepository;

import java.util.List;

/*
    Class containing the business logic for managing user profiles.
 */

@Service //Marking the class as a service, making it a spring-managed bean
public class UserProfileService {

    private final UserProfileRepository userProfileRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired // Automatically handling DI for UserProfileRepository
    public UserProfileService(UserProfileRepository userProfileRepository, PasswordEncoder passwordEncoder) {
        this.userProfileRepository = userProfileRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Get all users
    public List<UserProfile> getAllUsers() {
        return userProfileRepository.findAll();
    }

    // Save a user with error handling
    public void saveUser(UserProfile user) {
        try {
            userProfileRepository.save(user);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save user: " + e.getMessage());
        }
    }

    // Find a user by email
    public UserProfile findByEmail(String email) {
        return userProfileRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
    }

    // Register a new user
    public UserProfile registerUser(UserProfile userProfile) {
        // Checking if a user with the given email already exists in the database
        if (userProfileRepository.existsByEmail(userProfile.getEmail())) {
            // throwing an exception if the email is already registered
            throw new IllegalStateException("Email already in use");
        }
        // Encoding the user's password using BCryptPasswordEncoder before saving to database
        userProfile.setPassword(passwordEncoder.encode(userProfile.getPassword()));
        // Persisting the user into the database utilizing the UserProfileRepository layer
        return userProfileRepository.save(userProfile);
    }
}
