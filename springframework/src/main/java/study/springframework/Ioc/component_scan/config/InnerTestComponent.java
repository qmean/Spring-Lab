package study.springframework.Ioc.component_scan.config;

import org.springframework.stereotype.Component;
import study.springframework.basecomponent.TestBean;

@Component
public class InnerTestComponent implements TestBean{
    @Override
    public void printMyName() {
        System.out.println("InnerTestComponent");
    }
}
