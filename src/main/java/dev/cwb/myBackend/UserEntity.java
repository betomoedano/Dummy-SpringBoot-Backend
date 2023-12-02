package dev.cwb.myBackend;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "Users") // Ensure this matches your SQL table name
public class UserEntity {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String firstName;

    private String lastName;

    private String email;

    private String picture;
    
    private Boolean preferredCustomer;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;

    // No-arg constructor
    public UserEntity() {
    }

    // Constructor without id and createdAt, as these are auto-generated
    public UserEntity(String firstName, String lastName, String email, String picture, Boolean preferredCustomer) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.picture = picture;
        this.preferredCustomer = preferredCustomer;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Boolean getPreferredCustomer() {
        return preferredCustomer;
    }

    public void setPreferredCustomer(Boolean preferredCustomer) {
        this.preferredCustomer = preferredCustomer;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }


}
