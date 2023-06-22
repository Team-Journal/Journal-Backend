package com.example.journal.domain.post.domain.repository;

import com.example.journal.domain.post.domain.Posts;
import com.example.journal.domain.post.present.dto.response.PostsListResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    List<Posts> findAll();
    Optional<Posts> findPostsById(Long id);
    List<Posts> findPostsByAuthor(String author);
    Optional<Posts> findById(Long id);
    Optional<Posts> deletePostsById(Long id);

}
