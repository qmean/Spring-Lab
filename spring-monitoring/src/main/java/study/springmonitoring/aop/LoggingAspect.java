package study.springmonitoring.aop;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class LoggingAspect {

	ObjectMapper objectMapper = new ObjectMapper();

	@Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping) || "
		+ "@annotation(org.springframework.web.bind.annotation.PostMapping) || "
		+ "@annotation(org.springframework.web.bind.annotation.PutMapping) || "
		+ "@annotation(org.springframework.web.bind.annotation.DeleteMapping) || "
		+ "@annotation(org.springframework.web.bind.annotation.PatchMapping) || "
		+ "@annotation(org.springframework.web.bind.annotation.RequestMapping)")
	public void controllerLogging() {
	}

	@Around("controllerLogging()")
	private Object loggingExecutingTimeInController(ProceedingJoinPoint joinPoint) throws Throwable{
		long start = System.currentTimeMillis();
		Object result;
		Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
		try {
			result = joinPoint.proceed();
		} finally {
			logger.info("Execution time: {}ms", System.currentTimeMillis() - start);
		}
		return result;
	}

	@Around("controllerLogging()")
	private Object loggingQueryCountInController(ProceedingJoinPoint joinPoint) throws Throwable{
		Object result;
		QueryCountInspector.resetQueryCount();
		Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
		try {
			result = joinPoint.proceed();
		} finally {
			logger.info("Query count: {}", QueryCountInspector.getQueryCount());
			QueryCountInspector.resetQueryCount();
		}
		return result;
	}

	@Around("controllerLogging()")
	public Object logController(ProceedingJoinPoint joinPoint) throws Throwable {
		Class<?> clazz = joinPoint.getTarget().getClass();
		Logger logger = LoggerFactory.getLogger(clazz);
		Object result = null;

		try {
			result = joinPoint.proceed();
			return result;
		} finally {
			logger.info(getRequestUrl(joinPoint, clazz));
			logger.info("parameters: {}", objectMapper.writeValueAsString(params(joinPoint)));
			logger.info("response: {}", objectMapper.writeValueAsString(result));
		}
	}

	private Map<String, Object> params(ProceedingJoinPoint joinPoint) {
		CodeSignature codeSignature = (CodeSignature)joinPoint.getSignature();
		String[] parameterNames = codeSignature.getParameterNames();
		Object[] args = joinPoint.getArgs();
		Map<String, Object> params = new HashMap<>();
		for (int i = 0; i < parameterNames.length; i++) {
			params.put(parameterNames[i], args[i]);
		}
		return params;
	}

	private String getRequestUrl(ProceedingJoinPoint joinPoint, Class clazz) {
		MethodSignature signature = (MethodSignature)joinPoint.getSignature();
		Method method = signature.getMethod();
		RequestMapping requestMapping = (RequestMapping)clazz.getAnnotation(RequestMapping.class);
		String baseUrl = requestMapping.value()[0];

		return Stream.of(GetMapping.class, PostMapping.class, PatchMapping.class, DeleteMapping.class,
				RequestMapping.class,
				PutMapping.class)
			.filter(method::isAnnotationPresent)
			.map(mappingClass -> getUrl(method, mappingClass, baseUrl))
			.findFirst().orElse(null);
	}

	private String getUrl(Method method, Class<? extends Annotation> mappingClass, String baseUrl) {
		Annotation annotation = method.getAnnotation(mappingClass);
		String[] value;
		String httpMethod = null;
		try {
			value = (String[])mappingClass.getMethod("value").invoke(annotation);
			httpMethod = (mappingClass.getSimpleName().replace("Mapping", "")).toUpperCase();
		} catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
			return null;
		}
		return String.format("%s %s%s", httpMethod, baseUrl, value.length > 0 ? value[0] : "");
	}
}
