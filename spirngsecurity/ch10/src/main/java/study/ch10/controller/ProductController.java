package study.ch10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.logging.Logger;

@Controller
public class ProductController {

    Logger logger = Logger.getLogger(ProductController.class.getName());

    @PostMapping("/product/add")
    public String addProduct() {
        logger.info("Adding Product");
        return "main";
    }
}
