package study.springframework.Ioc.component_scan;

import org.springframework.stereotype.Component;
import study.springframework.basecomponent.TestBean;

@Component
public class OuterTestComponent implements TestBean {
    @Override
    public void printMyName() {
        System.out.println("OuterTestComponent");
    }
}
