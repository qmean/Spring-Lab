package study.springframework.Ioc.autowired.basic_test_beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.springframework.basecomponent.TestRepository;
import study.springframework.basecomponent.TestService;

@Service
public class SetterAutowiredService implements TestService {

    private TestRepository testRepository;

    @Autowired
    public void setTestRepository(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Override
    public void printMyName() {
        System.out.println("testRepository = " + testRepository);
        System.out.println("SetterAutowiredService");
    }
}
