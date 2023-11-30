package dev.cwb.myBackend;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "users") // Specify the table name if it's different from the class name
public class UserEntity {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private LocalDateTime created_at;

    // No-arg constructor
    public UserEntity() {
    }

    // All-args constructor
    public UserEntity(Long id, String username, String email, LocalDateTime created_at) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.created_at = created_at;
    }

    @PrePersist
    protected void onCreate() {
      created_at = LocalDateTime.now();
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getCreatedAt() {
        return created_at;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCreatedAt(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    // toString method
    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", created_at='" + created_at + '\'' +
                '}';
    }
}
