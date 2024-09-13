package study.springframework.Ioc.autowired.basic_test_beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.springframework.Ioc.base.TestService;

@Service
public class FiledAutowiredService implements TestService {

	@Autowired
	private BaseRepository baseRepository;

	@Override
	public void printMyName() {
		System.out.println("baseRepository = " + baseRepository);
		System.out.println("FiledAutowiredService");
	}
}
