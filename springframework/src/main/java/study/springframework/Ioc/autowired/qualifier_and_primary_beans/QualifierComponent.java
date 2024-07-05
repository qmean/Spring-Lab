package study.springframework.Ioc.autowired.qualifier_and_primary_beans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import study.springframework.basecomponent.TestBean;

@Component
public class QualifierComponent {
    private final TestBean testBean;

    public QualifierComponent(@Qualifier("qualifierBean") TestBean testBean) {
        this.testBean = testBean;
    }

    public void printMyName() {
        System.out.println("testBean = " + testBean);
        System.out.println("QualifierComponent");
    }
}
