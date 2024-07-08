package study.springframework.Ioc.autowired;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.springframework.Ioc.autowired.config.PrimaryConfig;
import study.springframework.Ioc.autowired.config.WithoutPrimaryConfig;
import study.springframework.Ioc.autowired.primary_test_beans.WithPrimaryTestComponent;

class PrimaryTest {

    @Test
    void withoutPrimaryTest() {
        Assertions.assertThatThrownBy(() -> new AnnotationConfigApplicationContext(WithoutPrimaryConfig.class))
                .isInstanceOf(BeanDefinitionStoreException.class);
    }

    @Test
    void primaryTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(PrimaryConfig.class);
        WithPrimaryTestComponent bean = ac.getBean(WithPrimaryTestComponent.class);
        bean.printMyName();
    }
}