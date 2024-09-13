package study.springframework.Ioc.component_scan.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import study.springframework.Ioc.component_scan.OuterTestComponent;
import study.springframework.Ioc.base.TestBean;

@Configuration
@ComponentScan(
	includeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {OuterTestComponent.class})},
	excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {InnerTestComponent.class})}
)
public class ComponentScanClassFiltersConfig implements TestBean {
	@Override
	public void printMyName() {
		System.out.println("ComponentScanClassFiltersConfig");
	}
}
