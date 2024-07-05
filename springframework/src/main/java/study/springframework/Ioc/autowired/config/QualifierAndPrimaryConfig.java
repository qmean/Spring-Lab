package study.springframework.Ioc.autowired.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"study.springframework.Ioc.autowired.qualifier_and_primary_beans"})
public class QualifierAndPrimaryConfig {
}
