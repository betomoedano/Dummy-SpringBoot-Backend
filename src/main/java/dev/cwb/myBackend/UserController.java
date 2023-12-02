package dev.cwb.myBackend;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
  
  @Autowired
  private UserRepository userRepository;

  @GetMapping
  public List<UserEntity> getAllUsers() {
    return userRepository.findAll();
  }

  @GetMapping("/users/{id}")
  public ResponseEntity<UserEntity> findById(@PathVariable UUID id) {
    Optional<UserEntity> userOptional = userRepository.findById(id);
      if (userOptional.isPresent()) {
        return ResponseEntity.ok(userOptional.get());
      } else {
        return ResponseEntity.notFound().build();
      }
  }

  @PostMapping
  public UserEntity createUser(@RequestBody UserEntity user) {
    return userRepository.save(user);
  }
}
