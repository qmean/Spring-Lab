package study.jwtstudy.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import study.jwtstudy.dto.JoinDto;
import study.jwtstudy.service.JoinService;

@RestController
@RequiredArgsConstructor
public class JoinController {

	private final JoinService joinService;

	@PostMapping("/join")
	public String joinProcess(JoinDto joinDto) {
		joinService.joinProcess(joinDto);
		return "ok";
	}
}
