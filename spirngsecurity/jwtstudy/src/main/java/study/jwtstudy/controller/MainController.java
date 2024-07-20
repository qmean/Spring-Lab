package study.jwtstudy.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class MainController {

	@GetMapping("/")
	public String mainP() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		String username = authentication.getName();
		String role = authentication.getAuthorities().iterator().next().getAuthority();

		return "Main Controller" + username + " : " + role;
	}
}
