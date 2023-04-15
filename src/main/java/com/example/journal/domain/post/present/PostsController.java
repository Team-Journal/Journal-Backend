package com.example.journal.domain.post.present;

import com.example.journal.domain.post.present.dto.request.PostSaveRequestDto;
import com.example.journal.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/posts")
@RestController
@RequiredArgsConstructor
public class PostsController {
    private final PostService postService;

    @PostMapping("/post")
    public void save(@RequestBody PostSaveRequestDto requestDto) {
        postService.save(requestDto);
    }
}
