package study.oauth2basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import study.oauth2basic.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	UserEntity findByUsername(String username);
}
