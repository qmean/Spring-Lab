package study.springframework.Ioc.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import study.springframework.Ioc.base.TestBean;

@Configuration
public class BeanConfig {
	@Bean
	public TestBean testBean() {
		return new TestBeanImpl("default name : name = \"\"");
	}

	@Bean(name = "testBean")
	public TestBean testBean2() {
		return new TestBeanImpl("duplicated name : name = \"testBeanImpl\"");
	}

	@Bean(name = "secondBean")
	public TestBean testBean3() {
		return new TestBeanImpl("custom name : name = \"secondBean\"");
	}
}
