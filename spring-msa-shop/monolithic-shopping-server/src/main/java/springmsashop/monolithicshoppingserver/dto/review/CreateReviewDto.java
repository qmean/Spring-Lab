package springmsashop.monolithicshoppingserver.dto.review;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class ReviewCreateDto {

	@Getter
	@AllArgsConstructor
	public static class Request{
		private String title;
		private String content;
	}
}
