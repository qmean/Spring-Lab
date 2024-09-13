package study.springframework.Ioc.autowired.qualifier_test_beans;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

import study.springframework.Ioc.base.TestBean;

@Component
@RequiredArgsConstructor
public class WithoutQualifierTestComponent implements TestBean {

	private final TestBean testBean;

	@Override
	public void printMyName() {
		System.out.println("testBean = " + testBean);
		System.out.println("WithoutQualifierTestComponent");
	}
}
