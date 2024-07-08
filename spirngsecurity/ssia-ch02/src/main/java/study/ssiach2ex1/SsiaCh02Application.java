package study.ssiach2ex1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages =
        {"study.ssiach2ex1.configuration",
        "study.ssiach2ex1.controller"}
)
public class SsiaCh02Application {

    public static void main(String[] args) {
        SpringApplication.run(SsiaCh02Application.class, args);
    }

}
