package study.springmonitoring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import study.springmonitoring.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
