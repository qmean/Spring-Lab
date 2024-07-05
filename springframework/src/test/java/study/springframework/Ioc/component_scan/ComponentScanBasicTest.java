package study.springframework.Ioc.component_scan;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.springframework.Ioc.component_scan.config.ComponentScanBasicConfig;
import study.springframework.basecomponent.TestBean;

import java.util.Map;

public class ComponentScanBasicTest {
    @Test
    public void basicTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ComponentScanBasicConfig.class);
        Map<String, TestBean> beansOfType = ac.getBeansOfType(TestBean.class);
        beansOfType.forEach((beanName, bean) -> {
            System.out.println("====================================");
            System.out.println("beanName = " + beanName);
            bean.printMyName();
        });
    }
}
