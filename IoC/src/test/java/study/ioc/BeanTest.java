package study.ioc;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanNotOfRequiredTypeException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

public class BeanTest {

    static class TestBean1 {
        public TestBean1() {
            System.out.println("TestBean1 constructor");
        }
    }

    @Scope("prototype")
    static class TestBean2 {
        public TestBean2() {
            System.out.println("TestBean2 constructor");
        }
    }

    @Configuration
    static class TestConfiguration {
        public TestConfiguration() {
            System.out.println("TestConfiguration constructor");
        }

        @Bean(name = "defaultTestBean1")
        public TestBean1 testBean1() {
            return new TestBean1();
        }

        @Bean
        public TestBean2 testBean2() {
            return new TestBean2();
        }
    }

    @Test
    @DisplayName("Bean 가져오기 테스트")
    public void applicationContextTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfiguration.class);
        System.out.println("getBean TestBean1");
        TestBean1 getBeanByClass = ac.getBean(TestBean1.class);
        System.out.println("getBeanByClass = " + getBeanByClass);
        TestBean1 getBeanByName = ac.getBean("defaultTestBean1", TestBean1.class);
        System.out.println("getBeanByName = " + getBeanByName);
        Assertions.assertThatThrownBy(() -> ac.getBean("defaultTestBean1", TestBean2.class))
                .isInstanceOf(BeanNotOfRequiredTypeException.class);
        Assertions.assertThatThrownBy(() -> ac.getBean("wrongBeanName", TestBean1.class))
                .isInstanceOf(NoSuchBeanDefinitionException.class);
    }

    @Test
    public void beanScopeTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfiguration.class);
        System.out.println("getBean TestBean2");
        TestBean2 testBean1 = ac.getBean(TestBean2.class);
        System.out.println("testBean1 = " + testBean1);
        TestBean2 testBean2 = ac.getBean(TestBean2.class);
        System.out.println("testBean2 = " + testBean2);
    }
}
