package study.ch10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Logger;

@Controller
public class MainController {

    Logger logger = Logger.getLogger(MainController.class.getName());

    @GetMapping("/")
    public String root() {
        return "cors_main";
    }

    @PostMapping("/test")
    @ResponseBody
    @CrossOrigin
    public String test() {
        logger.info("Test method called");
        return "Hello";
    }

    @GetMapping("/main")
    public String mainPage() {
        return "main";
    }
}
