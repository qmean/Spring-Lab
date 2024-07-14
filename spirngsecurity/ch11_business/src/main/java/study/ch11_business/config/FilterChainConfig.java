package study.ch11_business.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.client.RestTemplate;
import study.ch11_business.filter.InitialAuthenticationFilter;
import study.ch11_business.filter.JwtAuthenticationFilter;
import study.ch11_business.provider.OtpAuthenticationProvider;
import study.ch11_business.provider.UsernamePasswordAuthenticationProvider;

@Configuration
@RequiredArgsConstructor
public class FilterChainConfig {

    private final InitialAuthenticationFilter initialAuthenticationFilter;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
//    private final OtpAuthenticationProvider otpAuthenticationProvider;
//    private final UsernamePasswordAuthenticationProvider usernamePasswordAuthenticationProvider;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.authenticationProvider(otpAuthenticationProvider);
//        http.authenticationProvider(usernamePasswordAuthenticationProvider);
        http.csrf(AbstractHttpConfigurer::disable);
        http
                .addFilterAt(initialAuthenticationFilter, BasicAuthenticationFilter.class)
                .addFilterAfter(jwtAuthenticationFilter, BasicAuthenticationFilter.class);

        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
        return http.build();
    }

}
