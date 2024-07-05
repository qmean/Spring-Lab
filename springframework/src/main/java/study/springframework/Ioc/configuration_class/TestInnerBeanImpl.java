package study.springframework.Ioc.configuration_class;

public class TestInnerBeanImpl {
    public void printMyName() {
        System.out.println("TestInnerBean");
    }

    public TestInnerBeanImpl() {
        System.out.println("TestInnerBean constructor");
    }
}
