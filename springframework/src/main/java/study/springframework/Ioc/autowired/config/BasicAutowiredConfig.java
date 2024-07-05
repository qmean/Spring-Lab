package study.springframework.Ioc.autowired.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"study.springframework.Ioc.autowired.basic_test_beans"})
public class BasicAutowiredConfig {
}
