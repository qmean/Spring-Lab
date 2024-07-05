package study.springframework.Ioc.autowired.qualifier_test_beans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import study.springframework.basecomponent.TestBean;

@Component
@Qualifier("testBean1")
public class QualifiedBean1 implements TestBean {
    @Override
    public void printMyName() {
        System.out.println("QualifiedBean1");
    }
}
