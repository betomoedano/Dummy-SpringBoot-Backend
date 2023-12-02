package dev.cwb.myBackend;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserEntity, UUID> {
}
