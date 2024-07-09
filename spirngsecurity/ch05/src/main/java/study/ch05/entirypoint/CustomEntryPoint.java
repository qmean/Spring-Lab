package study.ch05.entirypoint;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;

public class CustomEntryPoint implements AuthenticationEntryPoint {

    /**
     * 인증 실패시 호출되는 메서드
     * ExceptionTranslationManager 라는 구성 요소에서 사용
     * -> 필터 체인에서 발생한 예외를 처리하는 역할
     * @param request
     * @param response
     * @param authException
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.getWriter().println("You are not authorized to access this resource");
        response.setStatus(401);
    }
}
