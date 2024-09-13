package study.springframework.Ioc.autowired.primary_test_beans;

import org.springframework.stereotype.Component;

import study.springframework.Ioc.base.TestBean;

@Component
public class TestBean1 implements TestBean {
	@Override
	public void printMyName() {
		System.out.println("TestBean1");
	}
}
