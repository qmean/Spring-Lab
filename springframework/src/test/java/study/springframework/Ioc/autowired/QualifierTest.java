package study.springframework.Ioc.autowired;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.springframework.Ioc.autowired.config.QualifierConfig;
import study.springframework.Ioc.autowired.config.WithoutQualifierConfig;
import study.springframework.Ioc.autowired.qualifier_test_beans.WithQualifierTestComponent;

class QualifierTest {

    @Test
    void withoutQualifierTest() {
        Assertions.assertThatThrownBy(() -> new AnnotationConfigApplicationContext(WithoutQualifierConfig.class))
                .isInstanceOf(BeanDefinitionStoreException.class);
    }

    @Test
    void qualifierTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(QualifierConfig.class);
        WithQualifierTestComponent bean = ac.getBean(WithQualifierTestComponent.class);
         bean.printMyName();
    }
}