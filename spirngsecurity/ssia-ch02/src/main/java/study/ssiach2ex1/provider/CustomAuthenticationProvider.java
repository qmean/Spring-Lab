package study.ssiach2ex1.provider;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 * 인증 처리를 위한 커스텀 AuthenticationProvider
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // 인증 논리 구현
        Logger logger = Logger.getLogger("CustomAuthenticationProvider");
        logger.info("CustomAuthenticationProvider.authenticate");
        String username = authentication.getName();
        String password = String.valueOf(authentication.getCredentials());

        if ("john".equals(username) && "12345".equals(password)) {
            // 인증 성공
            return new UsernamePasswordAuthenticationToken(username, password, Arrays.asList());
        } else {
            throw new AuthenticationCredentialsNotFoundException("Error in authentication");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        // 인증 처리 가능한 타입인지 확인
        return UsernamePasswordAuthenticationToken.class
                .isAssignableFrom(authentication);
    }
}
