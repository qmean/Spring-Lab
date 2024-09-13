package study.springframework.Ioc.autowired.basic_test_beans;

import org.springframework.stereotype.Service;

import study.springframework.Ioc.base.TestRepository;
import study.springframework.Ioc.base.TestService;

@Service
public class ConstructorAutowiredSkipService implements TestService {

	private final TestRepository testRepository;

	public ConstructorAutowiredSkipService(TestRepository testRepository) {
		this.testRepository = testRepository;
	}

	@Override
	public void printMyName() {
		System.out.println("testRepository = " + testRepository);
		System.out.println("ConstructorAutowiredSkipService");
	}
}
