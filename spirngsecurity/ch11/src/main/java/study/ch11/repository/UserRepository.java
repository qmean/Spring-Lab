package study.ch11.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.ch11.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsername(String username);
}
