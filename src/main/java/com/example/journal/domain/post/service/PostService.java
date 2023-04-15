package com.example.journal.domain.post.service;

import com.example.journal.domain.post.domain.Posts;
import com.example.journal.domain.post.domain.repository.PostsRepository;
import com.example.journal.domain.post.present.dto.request.PostSaveRequestDto;
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
    public void save(PostSaveRequestDto request){
        postsRepository.save(
                Posts.builder()
                        .title(request.getTitle())
                        .content(request.getContent())
                        .author(userFacade.getCurrentUser().getAccountId())
                        .build()
        );
    }
}
