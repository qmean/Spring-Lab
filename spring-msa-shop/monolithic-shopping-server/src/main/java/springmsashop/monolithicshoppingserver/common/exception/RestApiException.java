package springmsashop.monolithicshoppingserver.common.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import springmsashop.monolithicshoppingserver.common.api.ErrorCode;

@Getter
@RequiredArgsConstructor
public class RestApiException extends RuntimeException {
	private final ErrorCode errorCode;
}
