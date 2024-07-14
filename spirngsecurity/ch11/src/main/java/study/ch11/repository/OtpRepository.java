package study.ch11.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.ch11.config.Otp;

import java.util.Optional;

public interface OtpRepository extends JpaRepository<Otp, String> {
    Optional<Otp> findOtpByUsername(String username);
}
