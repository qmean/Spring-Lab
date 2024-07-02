package study.springframework.Ioc.spring_container;

import study.springframework.basecomponent.TestBean;

public class TestBeanImpl implements TestBean {
    @Override
    public void print() {
        System.out.println("TestBeanImpl.print()");
    }
}
