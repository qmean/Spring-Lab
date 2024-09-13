package study.springframework.Ioc.component_scan.basic_test_package;

import org.springframework.stereotype.Repository;

import study.springframework.Ioc.base.TestRepository;

@Repository
public class ComponentScanRepository implements TestRepository {
	@Override
	public void save() {
		System.out.println("ComponentScanRepository.save()");
	}

	@Override
	public void delete() {
		System.out.println("ComponentScanRepository.delete()");
	}

	@Override
	public void update() {
		System.out.println("ComponentScanRepository.update()");
	}

	@Override
	public void select() {
		System.out.println("ComponentScanRepository.select()");
	}

	@Override
	public void printMyName() {
		System.out.println("ComponentScanRepository");
	}
}
