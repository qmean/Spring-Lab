package study.ch04.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class CustomPasswordEncoderConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {

    }
}
