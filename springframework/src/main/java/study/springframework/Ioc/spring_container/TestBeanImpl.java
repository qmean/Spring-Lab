package study.springframework.Ioc.spring_container;

import study.springframework.Ioc.base.TestBean;

public class TestBeanImpl implements TestBean {
	@Override
	public void printMyName() {
		System.out.println("InnerTestComponent");
	}
}
