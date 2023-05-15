package com.example.journal.domain.post.service;

import com.example.journal.domain.post.domain.Posts;
import com.example.journal.domain.post.domain.repository.PostsRepository;
import com.example.journal.domain.post.exception.PostAccessDeniedException;
import com.example.journal.domain.post.exception.PostNotFoundException;
import com.example.journal.domain.post.present.dto.request.PostRequestDto;
import com.example.journal.domain.post.present.dto.response.PostsListResponse;
import com.example.journal.domain.post.present.dto.response.PostsResponse;
import com.example.journal.domain.user.domain.User;
import com.example.journal.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostsRepository postsRepository;

    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public PostsListResponse findAllDesc() {
        List<PostsResponse> postsList = postsRepository.findAll().stream()
                .map(posts -> new PostsResponse(
                        posts.getId(),
                        posts.getTitle(),
                        posts.getContent(),
                        posts.getAuthor()
                )).collect(Collectors.toList());

        return new PostsListResponse(postsList);
    }

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
        User currentUser = userFacade.getCurrentUser();

        if(!currentUser.getAccountId().equals(posts.getAuthor())) {
            throw PostAccessDeniedException.EXCEPTION;
        }

        posts.update(request.getTitle(), request.getContent());
    }

    @Transactional
    public void deleteById(Long id){
        Posts posts = postsRepository.findPostsById(id)
                .orElseThrow(() -> PostNotFoundException.EXCEPTION);

        User currentUser = userFacade.getCurrentUser();

        if(!currentUser.getAccountId().equals(posts.getAuthor())) {
            throw PostAccessDeniedException.EXCEPTION;
        }

        postsRepository.deleteById(id);
    }
}
