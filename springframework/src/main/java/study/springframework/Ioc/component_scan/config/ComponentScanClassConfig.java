package study.springframework.Ioc.component_scan.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import study.springframework.Ioc.base.TestBean;

@Configuration
@ComponentScan(basePackageClasses =
	{study.springframework.Ioc.component_scan.basic_test_package.ComponentScanTestController.class})
public class ComponentScanClassConfig implements TestBean {
	@Override
	public void printMyName() {
		System.out.println("ComponentScanClassConfig");
	}
}
