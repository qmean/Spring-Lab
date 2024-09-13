package study.springframework.Ioc.autowired.primary_test_beans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import study.springframework.Ioc.base.TestBean;

@Component
@Primary
public class PrimaryBean implements TestBean {
	@Override
	public void printMyName() {
		System.out.println("PrimaryBean");
	}
}
