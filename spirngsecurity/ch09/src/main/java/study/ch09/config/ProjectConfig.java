package study.ch09.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import study.ch09.filters.AuthenticationLoggingFilter;
import study.ch09.filters.RequestValidationFilter;
import study.ch09.filters.StaticKeyAuthenticationFilter;

@Configuration
public class ProjectConfig {

    @Autowired
    private StaticKeyAuthenticationFilter filter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.addFilterBefore(new RequestValidationFilter(), BasicAuthenticationFilter.class);
        httpSecurity.addFilterAfter(new AuthenticationLoggingFilter(), RequestValidationFilter.class);
        httpSecurity.addFilterAt(filter, BasicAuthenticationFilter.class);
        httpSecurity.authorizeHttpRequests(auth -> {
            auth.anyRequest().permitAll();
        });
        return httpSecurity.build();
    }
}
