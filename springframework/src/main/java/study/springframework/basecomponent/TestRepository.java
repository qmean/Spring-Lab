package study.springframework.basecomponent;

public interface TestRepository extends TestBean {
    void save();
    void delete();
    void update();
    void select();
}
