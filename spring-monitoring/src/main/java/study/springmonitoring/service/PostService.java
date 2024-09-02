package study.springmonitoring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import study.springmonitoring.entity.Post;
import study.springmonitoring.repository.PostRepository;

@Transactional
@RequiredArgsConstructor
@Service
public class PostService {

	private final PostRepository postRepository;

	public List<Post> getPosts() {
		postRepository.findById(1L);
		postRepository.findById(2L);

		return postRepository.findAll();
	}

	public Post savePost(Post post) {
		return postRepository.save(post);
	}
}
