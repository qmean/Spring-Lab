package study.springframework.Ioc.component_scan.basic_test_package;
import org.springframework.stereotype.Component;
import study.springframework.basecomponent.TestBean;

@Component
public class ComponentScanTestBean implements TestBean {
    @Override
    public void printMyName() {
        System.out.println("ComponentScanTestBean");
    }
}
