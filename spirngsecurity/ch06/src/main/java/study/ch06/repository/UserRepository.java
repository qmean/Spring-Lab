package study.ch06.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.ch06.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String u);
}
