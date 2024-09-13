package study.springframework.Ioc.bean;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import study.springframework.Ioc.base.TestBean;

class BeanTest {

	@Test
	void getBeanByNameTest() {
		/**
		 * 같은 이름의 빈을 두개 정의한 경우
		 * 둘중 하나만 가져올 수 있음
		 */
		ApplicationContext ac = new AnnotationConfigApplicationContext(BeanConfig.class);
		TestBean testBean = (TestBean)ac.getBean("testBean");
		testBean.printMyName();
		Assertions.assertThat(testBean).isNotNull();
	}

	@Test
	void getBeanByNameAndTypeTest() {
		/**
		 * 같은 이름의 빈을 두개 정의한 경우
		 * 둘중 하나만 가져올 수 있음
		 */
		ApplicationContext ac = new AnnotationConfigApplicationContext(BeanConfig.class);
		TestBean testBean = ac.getBean("testBean", TestBean.class);
		testBean.printMyName();
		Assertions.assertThat(testBean).isNotNull();
	}

	@Test
	void getBeanByTypeTest() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(BeanConfig.class);
		/**
		 * 같은 클래스이지만 다른 이름의 빈이 여러개 존재하기 때문에
		 * NoUniqueBeanDefinitionException 발생
		 */
		Assertions.assertThatThrownBy(() -> ac.getBean(TestBean.class))
			.isInstanceOf(NoUniqueBeanDefinitionException.class);
	}

	@Test
	void getBeanByTypeAndNameTest() {
		/**
		 * 이름과 타입을 모두 지정한 경우
		 */
		ApplicationContext ac = new AnnotationConfigApplicationContext(BeanConfig.class);
		TestBean testBean = ac.getBean("secondBean", TestBean.class);
		testBean.printMyName();
		Assertions.assertThat(testBean).isNotNull();
	}
}
