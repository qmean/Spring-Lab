package study.ch06.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import study.ch06.provider.AuthenticationManagerService;

@RestController
@RequiredArgsConstructor
public class JoinController {

    private final AuthenticationManagerService authenticationManagerService;

    @PostMapping("/join")
    public String join(String username, String password) {
        authenticationManagerService.join(username, password);
        return "ok";
    }
}
