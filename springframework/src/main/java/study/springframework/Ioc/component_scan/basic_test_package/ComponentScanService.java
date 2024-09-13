package study.springframework.Ioc.component_scan.basic_test_package;

import org.springframework.stereotype.Service;

import study.springframework.Ioc.base.TestService;

@Service
public class ComponentScanService implements TestService {

	@Override
	public void printMyName() {
		System.out.println("ComponentScanService");
	}
}
