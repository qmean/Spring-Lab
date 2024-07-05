package study.springframework.Ioc.component_scan.annotation_test_package;

import study.springframework.Ioc.component_scan.IncludeAnnotation;
import study.springframework.basecomponent.TestBean;

@IncludeAnnotation
public class IncludeComponent implements TestBean {
    @Override
    public void printMyName() {
        System.out.println("IncludeComponent");
    }
}
