package study.springframework.Ioc.autowired.basic_test_beans;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.springframework.basecomponent.TestRepository;
import study.springframework.basecomponent.TestService;

@Service
@RequiredArgsConstructor
public class ConstructorAutowiredWithLombokService implements TestService {

    private final TestRepository testRepository;

    @Override
    public void printMyName() {
        System.out.println("testRepository = " + testRepository);
        System.out.println("ConstructorAutowiredWithLombokService");
    }
}
