package study.springframework.Ioc.configuration_class;

import org.springframework.beans.factory.annotation.Autowired;
import study.springframework.basecomponent.TestBean;

public class TestBeanImpl implements TestBean {

    private final TestInnerBeanImpl testInnerBean;

    @Autowired
    public TestBeanImpl(TestInnerBeanImpl testInnerBean) {
        System.out.println("InnerTestComponent constructor");
        this.testInnerBean = testInnerBean;
    }

    @Override
    public void printMyName() {
        System.out.println("InnerTestComponent");
    }

    boolean innerBeanComp(TestInnerBeanImpl param) {
        return testInnerBean == param;
    }
}
