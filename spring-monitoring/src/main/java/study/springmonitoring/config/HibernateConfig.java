package study.springmonitoring.config;

import org.hibernate.cfg.AvailableSettings;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;
import study.springmonitoring.aop.QueryCountInspector;

@Configuration
@RequiredArgsConstructor
public class HibernateConfig {

	private final QueryCountInspector queryCountInspector;

	@Bean
	public HibernatePropertiesCustomizer hibernatePropertiesCustomizer() {
		return hibernateProperties -> hibernateProperties.put(AvailableSettings.STATEMENT_INSPECTOR,
				queryCountInspector);
	}
}
