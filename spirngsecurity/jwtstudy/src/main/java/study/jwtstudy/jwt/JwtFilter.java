package study.jwtstudy.jwt;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import study.jwtstudy.dto.CustomUserDetails;
import study.jwtstudy.entity.UserEntity;

@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

	private final JwtUtil jwtUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
		FilterChain filterChain) throws ServletException, IOException {
		String authorization = request.getHeader("Authorization");

		if (authorization == null || !authorization.startsWith("Bearer ")) {
			System.out.println("token null");
			filterChain.doFilter(request, response);

			return ;
		}

		String token = authorization.split(" ")[1];

		if (jwtUtil.isExpired(token)) {
			System.out.println("token expired");
			filterChain.doFilter(request, response);

			return ;
		}

		String username = jwtUtil.getUsername(token);
		String role = jwtUtil.getRole(token);

		UserEntity userEntity = new UserEntity();
		userEntity.setUsername(username);
		userEntity.setRole("tempPassword");
		userEntity.setRole(role);

		CustomUserDetails customUserDetails = new CustomUserDetails(userEntity);

		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
			customUserDetails, null, customUserDetails.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authToken);

		System.out.println("token valid");
		filterChain.doFilter(request, response);
	}

	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
		String requestURI = request.getRequestURI();
		return requestURI.equals("/login");
	}
}
