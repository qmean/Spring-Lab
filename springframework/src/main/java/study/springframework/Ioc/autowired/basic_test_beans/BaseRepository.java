package study.springframework.Ioc.autowired.basic_test_beans;

import org.springframework.stereotype.Repository;

import study.springframework.Ioc.base.TestRepository;

@Repository
public class BaseRepository implements TestRepository {
	@Override
	public void save() {
		System.out.println("BaseRepository.save()");
	}

	@Override
	public void delete() {
		System.out.println("BaseRepository.delete()");
	}

	@Override
	public void update() {
		System.out.println("BaseRepository.update()");
	}

	@Override
	public void select() {
		System.out.println("BaseRepository.select()");
	}

	@Override
	public void printMyName() {
		System.out.println("BaseRepository");
	}
}
