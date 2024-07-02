package study.springframework.Ioc.spring_container;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.springframework.basecomponent.TestBean;

import static org.junit.jupiter.api.Assertions.*;

class SpringContainerTest {

    @Test
    void getBeanTest() {
        /**
         * ApplicationContext 는 스프링 컨테이너의 인스턴스를 의미한다.
         * AnnotationConfigApplicationContext 는 ApplicationContext 인터페이스를 구현한 클래스이다.
         * AnnotationConfigApplicationContext 는 자바 설정 클래스를 읽어서 빈 객체를 생성하고 관리한다.
         * 여기서 자바 설정 클래스란 @Configuration 이 붙은 자바 클래스를 의미한다.
         */
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringContainerConfig.class);
        TestBean testBean = ac.getBean("testBean", TestBean.class);
        testBean.print();
    }

    @Test
    void getBeansOfTypeTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringContainerConfig.class);
        ac.getBeansOfType(TestBean.class).forEach((name, bean) -> {
            System.out.println("name = " + name + " / bean = " + bean);
        });
    }

}