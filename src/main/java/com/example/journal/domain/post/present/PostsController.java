package com.example.journal.domain.post.present;

import com.example.journal.domain.post.present.dto.request.PostRequestDto;
import com.example.journal.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/posts")
@RestController
@RequiredArgsConstructor
public class PostsController {
    private final PostService postService;


    @GetMapping()

    @PostMapping("/post")
    public void save(@RequestBody PostRequestDto requestDto) {
        postService.save(requestDto);
    }

    @PutMapping("/post/{id}")
    public void update(@PathVariable Long id, @RequestBody PostRequestDto request){
        postService.update(id, request);
    }

    @DeleteMapping("/post/{id}")
    public void deleteById(@PathVariable Long id){
        postService.deleteById(id);
    }
}
