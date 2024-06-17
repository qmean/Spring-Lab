package study.ioc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class IoCApplication {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("appConfig.xml");
        Object xmlBean = context.getBean("xmlBean");
        System.out.println("xmlBean.toString() = " + xmlBean.toString());
//        SpringApplication.run(IoCApplication.class, args);
    }

}
