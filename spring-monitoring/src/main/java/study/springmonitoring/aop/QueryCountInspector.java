package study.springmonitoring.aop;

import org.hibernate.resource.jdbc.spi.StatementInspector;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class QueryCountInspector implements StatementInspector {

	private static final ThreadLocal<Integer> queryCount = ThreadLocal.withInitial(() -> 0);

	@Override
	public String inspect(String s) {
		queryCount.set(queryCount.get() + 1);
		return s;
	}

	public static int getQueryCount() {
		return queryCount.get();
	}

	public static void resetQueryCount() {
		queryCount.set(0);
	}
}
