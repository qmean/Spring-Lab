package study.springframework.Ioc.configuration_class;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ConfigurationClassTest {

    @Test
    void configurationTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ConfigurationClass.class);
        ConfigurationClass configurationBean = ac.getBean(ConfigurationClass.class);
        System.out.println("configurationBean = " + configurationBean);
    }

    @Test
    void configurationWithAnnotationTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ConfigurationClass.class);
        TestBeanImpl testBean = ac.getBean(TestBeanImpl.class);
        TestInnerBeanImpl innerBean = ac.getBean(TestInnerBeanImpl.class);
        System.out.println("testBeanImpl = " + testBean);
        System.out.println("innerBean = " + innerBean);
        System.out.println("testBeanImpl.innerBeanComp() = " + testBean.innerBeanComp(innerBean));
    }

    @Test
    void configurationWithoutAnnotationTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ConfigurationClassWithoutAnnotation.class);
        TestBeanImpl testBean = ac.getBean(TestBeanImpl.class);
        TestInnerBeanImpl innerBean = ac.getBean(TestInnerBeanImpl.class);
        System.out.println("testBeanImpl = " + testBean);
        System.out.println("innerBean = " + innerBean);
        System.out.println("testBeanImpl.innerBeanComp() = " + testBean.innerBeanComp(innerBean));
    }

}