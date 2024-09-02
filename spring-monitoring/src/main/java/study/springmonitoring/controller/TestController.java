package study.springmonitoring.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import study.springmonitoring.entity.Post;
import study.springmonitoring.service.PostService;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

	private final PostService postService;

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}

	@GetMapping("/post")
	public List<Post> getPosts() {
		return postService.getPosts();
	}

	@PostMapping("/post")
	public Post savePost(String title, String content) {
		Post post = Post.builder().title(title).content(content).build();
		return postService.savePost(post);
	}
}
