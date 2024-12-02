package perscholas.stevealexbowman.cap312.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    private Long id;
    private String name;
    private String email;

    // Getters and setters still need to be implemented
}