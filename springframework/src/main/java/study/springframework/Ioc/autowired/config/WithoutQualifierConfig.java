package study.springframework.Ioc.autowired.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import study.springframework.Ioc.autowired.qualifier_test_beans.WithQualifierTestComponent;

@Configuration
@ComponentScan(basePackages = {"study.springframework.Ioc.autowired.qualifier_test_beans"},
        excludeFilters = {@ComponentScan.Filter(WithQualifierTestComponent.class)}
)
public class WithoutQualifierConfig {
}
