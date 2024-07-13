package study.ch10.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

@Configuration
public class CorsBasicConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);
        http.authorizeHttpRequests(auth -> {
            auth.anyRequest().permitAll();
        });
        http.cors(cors -> {
           cors.configurationSource(request -> {
               CorsConfiguration config = new CorsConfiguration();
               config.setAllowedOrigins(List.of("example.com", "example.org"));
               config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
               return config;
           });
        });
        return http.build();
    }
}
