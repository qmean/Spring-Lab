package study.springframework.Ioc.autowired;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.springframework.Ioc.autowired.basic_test_beans.*;
import study.springframework.Ioc.autowired.config.BasicAutowiredConfig;

class BasicAutowiredTest {

    ApplicationContext ac = new AnnotationConfigApplicationContext(BasicAutowiredConfig.class);

    @Test
    void constructorAutowiredTest() {
        ConstructorAutowiredService bean = ac.getBean(ConstructorAutowiredService.class);
        bean.printMyName();
    }

    @Test
    void constructorAutowiredTest2() {
        ConstructorAutowiredSkipService bean = ac.getBean(ConstructorAutowiredSkipService.class);
        bean.printMyName();
    }

    @Test
    void constructorAutowiredSkipWithLombokTest() {
        ConstructorAutowiredWithLombokService bean = ac.getBean(ConstructorAutowiredWithLombokService.class);
        bean.printMyName();
    }

    @Test
    void setterAutowiredTest() {
        SetterAutowiredService bean = ac.getBean(SetterAutowiredService.class);
        bean.printMyName();
    }

    @Test
    void filedAutowiredTest() {
        FiledAutowiredService bean = ac.getBean(FiledAutowiredService.class);
        bean.printMyName();
    }

}