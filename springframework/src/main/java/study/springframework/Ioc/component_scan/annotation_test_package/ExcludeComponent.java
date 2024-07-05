package study.springframework.Ioc.component_scan.annotation_test_package;

import study.springframework.Ioc.component_scan.ExcludeAnnotation;
import study.springframework.basecomponent.TestBean;

@ExcludeAnnotation
public class ExcludeComponent implements TestBean {

    @Override
    public void printMyName() {
        System.out.println("ExcludeComponent");
    }
}
