package study.oauth2basic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;
import study.oauth2basic.oauth2.CustomClientRegistrationRepo;
import study.oauth2basic.oauth2.CustomOAuth2AuthorizedClientService;
import study.oauth2basic.service.CustomOAuth2UserService;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

	private final CustomOAuth2UserService customOAuth2UserService;
	private final CustomClientRegistrationRepo customClientRegistrationRepo;
	private final CustomOAuth2AuthorizedClientService customOAuth2AuthorizedClientService;
	private final JdbcTemplate jdbcTemplate;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.csrf(AbstractHttpConfigurer::disable);
		http
			.formLogin(AbstractHttpConfigurer::disable);
		http
			.httpBasic(AbstractHttpConfigurer::disable);
		http
			.oauth2Login(oauth2 -> {
				oauth2.loginPage("/login");
				oauth2.clientRegistrationRepository(customClientRegistrationRepo.clientRegistrationRepository());
				oauth2.authorizedClientService(
					customOAuth2AuthorizedClientService.oAuth2AuthorizedClientService(jdbcTemplate,
						customClientRegistrationRepo.clientRegistrationRepository()));
				oauth2.userInfoEndpoint(
					userInfoEndpointConfig -> userInfoEndpointConfig.userService(customOAuth2UserService));
			});
		http
			.authorizeHttpRequests(auth -> {
				auth.requestMatchers("/", "/oauth2/**", "/login/**").permitAll();
				auth.anyRequest().authenticated();
			});

		return http.build();
	}
}
