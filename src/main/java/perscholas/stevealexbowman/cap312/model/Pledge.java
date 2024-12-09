package perscholas.stevealexbowman.cap312.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pledges")
public class Pledge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private boolean pledge; // To represent whether the checkbox is selected

    @Column(name = "recycling_level", nullable = false)
    private String recyclingLevel;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public boolean isPledge() {
        return pledge;
    }

    public void setPledge(boolean pledge) {
        this.pledge = pledge;
    }

    public String getRecyclingLevel() {
        return recyclingLevel;
    }

    public void setRecyclingLevel(String recyclingLevel) {
        this.recyclingLevel = recyclingLevel;
    }
}
