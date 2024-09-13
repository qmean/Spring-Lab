package study.springframework.Ioc.component_scan.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import study.springframework.Ioc.component_scan.ExcludeAnnotation;
import study.springframework.Ioc.component_scan.IncludeAnnotation;
import study.springframework.Ioc.base.TestBean;

import static org.springframework.context.annotation.ComponentScan.*;

@Configuration
@ComponentScan(
	basePackages = "study.springframework.Ioc.component_scan.annotation_test_package",
	includeFilters = @Filter(type = FilterType.ANNOTATION, classes = {IncludeAnnotation.class}),
	excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = {ExcludeAnnotation.class})
)
public class ComponentScanAnnotationFiltersConfig implements TestBean {
	@Override
	public void printMyName() {
		System.out.println("ComponentScanAnnotationFiltersConfig");
	}
}
