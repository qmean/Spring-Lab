package study.springframework.Ioc.spring_container;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.springframework.basecomponent.TestBean;

@Configuration
public class SpringContainerConfig implements TestBean{
    @Bean
    public TestBean testBean() {
        return new TestBeanImpl();
    }

    @Bean
    public TestBean testBean2() {
        return new TestBeanImpl();
    }

    @Override
    public void printMyName() {
        System.out.println("SpringContainerConfig");
    }
}
