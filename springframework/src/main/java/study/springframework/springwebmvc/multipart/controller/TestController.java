package study.springframework.springwebmvc.multipart.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/test")
public class TestController {

	@PostMapping("/request-param")
	public List<String> multiPartTestWithRequestParam(@RequestParam("file") MultipartFile file) {
		List<String> result = List.of(
			file.getOriginalFilename(),
			file.getContentType(),
			String.valueOf(file.getSize())
		);
		return result;
	}

	@PostMapping("/request-part")
	public List<String> multiPartTestWithRequestPart(@RequestPart("file") MultipartFile file) {
		List<String> result = List.of(
			file.getOriginalFilename(),
			file.getContentType(),
			String.valueOf(file.getSize())
		);
		return result;
	}
}
