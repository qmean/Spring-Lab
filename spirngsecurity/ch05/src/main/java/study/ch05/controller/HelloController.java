package study.ch05.controller;

import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        System.out.println("hello");
        SecurityContext context = SecurityContextHolder.getContext();
        System.out.println("context = " + context);
        Authentication auth = context.getAuthentication();
        System.out.println("auth = " + auth);

        return "hello";
    }

    @GetMapping("/bye")
    public String bye() {
        SecurityContext context = SecurityContextHolder.getContext();
        String name = context.getAuthentication().getName();
        return ("bye " + name);
    }

    @GetMapping("/login")
    public String getIndex() {
        return "login";
    }

}

