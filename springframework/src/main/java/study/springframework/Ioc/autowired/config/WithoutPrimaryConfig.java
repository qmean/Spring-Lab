package study.springframework.Ioc.autowired.config;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import study.springframework.Ioc.autowired.primary_test_beans.PrimaryBean;
import study.springframework.Ioc.autowired.primary_test_beans.WithPrimaryTestComponent;

@Configuration
@ComponentScan(
        basePackages = {"study.springframework.Ioc.autowired.primary_test_beans"},
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = WithPrimaryTestComponent.class),
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = PrimaryBean.class)}
)
public class WithoutPrimaryConfig {
}
