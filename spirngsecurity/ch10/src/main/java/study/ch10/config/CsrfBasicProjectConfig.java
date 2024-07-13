package study.ch10.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CsrfFilter;
import study.ch10.filter.CsrfTokenLogger;

//@Configuration
public class CsrfBasicProjectConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.addFilterAfter(new CsrfTokenLogger(), CsrfFilter.class);
        http.authorizeHttpRequests(request -> {
            request.anyRequest().permitAll();
        });
        return http.build();
    }
}
