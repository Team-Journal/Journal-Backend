package com.example.journal.domain.post.service;

import com.example.journal.domain.post.domain.Posts;
import com.example.journal.domain.post.domain.repository.PostsRepository;
import com.example.journal.domain.post.exception.PostNotFoundException;
import com.example.journal.domain.post.present.dto.request.PostRequestDto;
import com.example.journal.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostsRepository postsRepository;

    private final UserFacade userFacade;

    @Transactional
    public void save(PostRequestDto request){
        postsRepository.save(
                Posts.builder()
                        .title(request.getTitle())
                        .content(request.getContent())
                        .author(userFacade.getCurrentUser().getAccountId())
                        .build()
        );
    }

    @Transactional
    public void update(Long id, PostRequestDto request){
        Posts posts = postsRepository.findPostsById(id)
                .orElseThrow(() -> PostNotFoundException.EXCEPTION);
        posts.update(request.getTitle(), request.getContent());
    }
}
