package study.springframework.Ioc.component_scan.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import study.springframework.Ioc.base.TestBean;

@Configuration
@ComponentScan
public class ComponentScanBasicConfig implements TestBean {
	@Override
	public void printMyName() {
		System.out.println("ComponentScanBasicConfig");
	}
}
