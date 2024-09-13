package study.springframework.Ioc.component_scan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import study.springframework.Ioc.base.TestBean;

@Configuration
@ComponentScan(basePackages = "study.springframework.Ioc.component_scan.basic_test_package")
public class ComponentScanPackageConfig implements TestBean {
	@Bean
	public InnerTestComponent testBeanImpl() {
		return new InnerTestComponent();
	}

	@Override
	public void printMyName() {
		System.out.println("ComponentScanPackageConfig");
	}
}
