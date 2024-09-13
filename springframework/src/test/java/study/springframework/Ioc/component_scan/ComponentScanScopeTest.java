package study.springframework.Ioc.component_scan;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import study.springframework.Ioc.component_scan.config.ComponentScanClassConfig;
import study.springframework.Ioc.component_scan.config.ComponentScanPackageConfig;
import study.springframework.Ioc.base.TestBean;

public class ComponentScanScopeTest {
	@Test
	void classScopeTest() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ComponentScanClassConfig.class);
		ac.getBeansOfType(TestBean.class).forEach((beanName, bean) -> {
			System.out.println("====================================");
			System.out.println("beanName = " + beanName);
			bean.printMyName();
		});
	}

	@Test
	void packageScopeTest() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ComponentScanPackageConfig.class);
		ac.getBeansOfType(TestBean.class).forEach((beanName, bean) -> {
			System.out.println("====================================");
			System.out.println("beanName = " + beanName);
			bean.printMyName();
		});
	}
}
