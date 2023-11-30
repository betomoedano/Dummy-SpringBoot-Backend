package dev.cwb.myBackend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

  @PostMapping
  public UserEntity createUser(@RequestBody UserEntity user) {
    return userRepository.save(user);
  }
}
