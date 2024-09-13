package study.springframework.Ioc.autowired.primary_test_beans;

import org.springframework.stereotype.Component;

import study.springframework.Ioc.base.TestBean;

@Component
public class WithoutPrimaryTestComponent {

	private final TestBean testBean;

	public WithoutPrimaryTestComponent(TestBean testBean) {
		this.testBean = testBean;
	}

	public void printMyName() {
		System.out.println("testBean = " + testBean);
		System.out.println("WithoutPrimaryTestComponent");
	}
}
