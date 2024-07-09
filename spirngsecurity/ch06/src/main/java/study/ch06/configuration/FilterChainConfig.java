package study.ch06.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@Configuration
public class FilterChainConfig {

    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);

        http.authenticationProvider(authenticationProvider);

        http.formLogin(form -> {
            form.defaultSuccessUrl("/main", true);
        });

        http.authorizeHttpRequests(request -> {
            request.requestMatchers("/join").permitAll();
            request.anyRequest().authenticated();
        });

        return http.build();
    }

}
