package study.springframework.Ioc.configuration_class;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import study.springframework.Ioc.base.TestBean;

@Configuration
public class ConfigurationClass implements TestBean {

	@Bean
	public TestBeanImpl testBean() {
		return new TestBeanImpl(testInnerBean());
	}

	@Bean
	public TestInnerBeanImpl testInnerBean() {
		return new TestInnerBeanImpl();
	}

	@Override
	public void printMyName() {
		System.out.println("ConfigurationClass");
	}
}
