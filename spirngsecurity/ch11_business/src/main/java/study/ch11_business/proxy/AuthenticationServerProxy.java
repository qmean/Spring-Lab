package study.ch11_business.proxy;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import study.ch11_business.User;

@Component
@RequiredArgsConstructor
@Slf4j
public class AuthenticationServerProxy {

    private final RestTemplate rest;

    @Value("${auth.server.base.url}")
    private String baseUrl;

    public void sendAuth(String username, String password) {
        log.debug("Sending auth request to {}", baseUrl);

        String url = baseUrl + "/user/auth";

        User body = new User();
        body.setUsername(username);
        body.setPassword(password);

        HttpEntity<User> request = new HttpEntity<>(body);

        rest.postForEntity(url, request, Void.class);
    }

    public boolean sendOtp(String username, String code) {
        log.debug("Sending otp request to {}", baseUrl);

        String usl = baseUrl + "/otp/check";

        User body = new User();
        body.setUsername(username);
        body.setCode(code);

        HttpEntity<User> request = new HttpEntity<>(body);

        ResponseEntity<Void> response = rest.postForEntity(usl, request, Void.class);

        return response
                .getStatusCode()
                .equals(HttpStatus.OK);
    }
}
