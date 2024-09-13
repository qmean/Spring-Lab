package study.springframework.Ioc.autowired.qualifier_and_primary_beans;

import org.springframework.stereotype.Component;

import study.springframework.Ioc.base.TestBean;

@Component
public class DefaultComponent {

	private final TestBean testBean;

	public DefaultComponent(TestBean testBean) {
		this.testBean = testBean;
	}

	public void printMyName() {
		System.out.println("testBean = " + testBean);
		System.out.println("DefaultComponent");
	}
}
