package study.ch12.controller;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Logger;

@Controller
public class MainController {

    Logger logger = Logger.getLogger(MainController.class.getName());

    @GetMapping("/")
    public String mainController(OAuth2AuthenticationToken token) {
        logger.info("Token: " + token);
        return "main";
    }
}
