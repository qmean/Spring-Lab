package study.ssiach2ex1.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;

@Configuration
public class WebAuthorizationConfig {

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests((authorize) ->
//                        authorize.anyRequest().authenticated())
//                .httpBasic(Customizer.withDefaults());
//        return http.build();
//    }

    @Bean
    public AuthenticationManager filterChain(AuthenticationConfiguration auth) throws Exception {
        /**
         * bean 으로 등록하면
         * 자동으로 AuthenticationProvider 추가 (우선순위 높음)
         * 자동으로 UserDetailService 추가
         * 자동으로 PasswordEncoder 추가
         */
        return auth.getAuthenticationManager();
    }
}
