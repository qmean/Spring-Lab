package study.springframework.Ioc.component_scan.basic_test_package;

import org.springframework.stereotype.Controller;

import study.springframework.Ioc.base.TestController;

@Controller
public class ComponentScanTestController implements TestController {

	@Override
	public void printMyName() {
		System.out.println("ComponentScanTestController");
	}
}
