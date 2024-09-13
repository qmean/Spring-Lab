package springmsashop.monolithicshoppingserver.dto.product;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class ProductUpdateDto {

	@Getter
	@AllArgsConstructor
	public static class Request {
		private String name;
		private Integer price;
		private Integer stock;
	}
}
