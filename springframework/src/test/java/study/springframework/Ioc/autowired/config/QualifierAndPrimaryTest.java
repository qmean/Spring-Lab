package study.springframework.Ioc.autowired.config;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.springframework.Ioc.autowired.qualifier_and_primary_beans.DefaultComponent;
import study.springframework.Ioc.autowired.qualifier_and_primary_beans.QualifierComponent;

class QualifierAndPrimaryTest {

    ApplicationContext ac = new AnnotationConfigApplicationContext(QualifierAndPrimaryConfig.class);

    @Test
    void defaultTest() {
        DefaultComponent bean = ac.getBean(DefaultComponent.class);
        bean.printMyName();
    }

    @Test
    void qualifierTest() {
        QualifierComponent bean = ac.getBean(QualifierComponent.class);
        bean.printMyName();
    }

}