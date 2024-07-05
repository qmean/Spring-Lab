package study.springframework.Ioc.configuration_class;

import org.springframework.context.annotation.Bean;

public class ConfigurationClassWithoutAnnotation{

    @Bean
    public TestBeanImpl testBean() {
        return new TestBeanImpl(new TestInnerBeanImpl());
    }

    @Bean
    public TestInnerBeanImpl testInnerBean() {
        return new TestInnerBeanImpl();
    }
}
