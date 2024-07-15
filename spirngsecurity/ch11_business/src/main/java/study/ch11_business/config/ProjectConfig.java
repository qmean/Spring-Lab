package study.ch11_business.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import study.ch11_business.provider.OtpAuthenticationProvider;
import study.ch11_business.provider.UsernamePasswordAuthenticationProvider;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class ProjectConfig {

    private final OtpAuthenticationProvider otpAuthenticationProvider;
    private final UsernamePasswordAuthenticationProvider usernamePasswordAuthenticationProvider;

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder builder = http.getSharedObject(AuthenticationManagerBuilder.class);
        builder.authenticationProvider(otpAuthenticationProvider);
        builder.authenticationProvider(usernamePasswordAuthenticationProvider);
        return builder.build();
    }
}
