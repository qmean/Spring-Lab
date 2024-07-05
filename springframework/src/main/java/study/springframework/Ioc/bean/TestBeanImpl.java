package study.springframework.Ioc.bean;

import study.springframework.basecomponent.TestBean;

public class TestBeanImpl implements TestBean {

    private String name;

    @Override
    public void printMyName() {
        System.out.println("name : " + name);
    }

    public TestBeanImpl(String name) {
        this.name = name;
    }
}
