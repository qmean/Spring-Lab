package study.springframework.Ioc.autowired.primary_test_beans;

import org.springframework.stereotype.Component;

import study.springframework.Ioc.base.TestBean;

@Component
public class WithPrimaryTestComponent {

	private final TestBean testBean;

	public WithPrimaryTestComponent(TestBean testBean) {
		this.testBean = testBean;
	}

	public void printMyName() {
		System.out.println("testBean = " + testBean);
		System.out.println("WithPrimaryTestComponent");
	}
}
