package springmsashop.monolithicshoppingserver.dto.review;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class ReviewUpdateDto {

	@Getter
	@AllArgsConstructor
	public static class Request {
		private String title;
		private String content;
	}
}
