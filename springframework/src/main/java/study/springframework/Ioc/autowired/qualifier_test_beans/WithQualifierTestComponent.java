package study.springframework.Ioc.autowired.qualifier_test_beans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import study.springframework.Ioc.base.TestBean;

@Component
public class WithQualifierTestComponent implements TestBean {

	private final TestBean testBean;

	public WithQualifierTestComponent(@Qualifier("testBean2") TestBean testBean) {
		this.testBean = testBean;
	}

	@Override
	public void printMyName() {
		System.out.println("testBean = " + testBean);
		System.out.println("WithQualifierTestComponent");
	}
}
