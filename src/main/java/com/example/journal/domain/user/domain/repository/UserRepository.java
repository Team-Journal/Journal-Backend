package com.example.journal.domain.user.domain.repository;

import com.example.journal.domain.post.domain.Posts;
import com.example.journal.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByAccountId(String accountId);
    Optional<User> findByEmail(String email);

    List<Posts> findPostsById(Long id);
}