package study.springframework.Ioc.base;

public interface TestRepository extends TestBean {
	void save();

	void delete();

	void update();

	void select();
}
