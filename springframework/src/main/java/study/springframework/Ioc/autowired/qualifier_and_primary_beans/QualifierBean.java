package study.springframework.Ioc.autowired.qualifier_and_primary_beans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import study.springframework.basecomponent.TestBean;

@Component
@Qualifier("qualifierBean")
public class QualifierBean implements TestBean {
    @Override
    public void printMyName() {
        System.out.println("QualifierBean");
    }
}
