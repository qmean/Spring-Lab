package study.springframework.Ioc.component_scan;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import study.springframework.Ioc.component_scan.config.ComponentScanAnnotationFiltersConfig;
import study.springframework.Ioc.component_scan.config.ComponentScanClassFiltersConfig;
import study.springframework.Ioc.base.TestBean;

import java.util.Map;

public class ComponentScanFilterTest {
	@Test
	void componentScanBasicFilterTest() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ComponentScanClassFiltersConfig.class);
		Map<String, TestBean> beans = ac.getBeansOfType(TestBean.class);
		beans.forEach((beanName, bean) -> {
			System.out.println("====================================");
			System.out.println("beanName = " + beanName);
			bean.printMyName();
		});
	}

	@Test
	void componentScanAnnotationFilterTest() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ComponentScanAnnotationFiltersConfig.class);
		Map<String, TestBean> beans = ac.getBeansOfType(TestBean.class);
		beans.forEach((beanName, bean) -> {
			System.out.println("====================================");
			System.out.println("beanName = " + beanName);
			bean.printMyName();
		});
	}
}
