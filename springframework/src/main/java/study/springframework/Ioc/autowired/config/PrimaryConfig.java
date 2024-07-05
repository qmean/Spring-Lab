package study.springframework.Ioc.autowired.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import study.springframework.Ioc.autowired.primary_test_beans.WithoutPrimaryTestComponent;

@Configuration
@ComponentScan(
        basePackages = {"study.springframework.Ioc.autowired.primary_test_beans"},
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = WithoutPrimaryTestComponent.class)
        }
)
public class PrimaryConfig {
}
