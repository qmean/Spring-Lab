package study.ch03.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import study.ch03.service.InMemoryUserDetailService;
import study.ch03.user.User;

import java.util.List;

//@Configuration
public class CustomUserDetailServiceTestConfig {

    /**
     * UserDetailsService 를 빈으로 등록
     */
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails u = new User("john", "12345", "read");
        List<UserDetails> users = List.of(u);
        return new InMemoryUserDetailService(users);
    }

    /**
     * 사용할 PasswordEncoder 를 빈으로 등록
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
