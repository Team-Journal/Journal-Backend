package com.example.journal.domain.post.present;

import com.example.journal.domain.post.present.dto.request.PostRequestDto;
import com.example.journal.domain.post.present.dto.response.PostsListResponse;
import com.example.journal.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/posts")
@RestController
@RequiredArgsConstructor
public class PostsController {
    private final PostService postService;
    

    @GetMapping("/")
    public PostsListResponse get(){
        return postService.findAllDesc();
    }

    @GetMapping("/{username}")
    public PostsListResponse getPostsByUsername(@PathVariable String username){
        return postService.findPostsByAuthor(username);
    }

    @PostMapping("/create")
    public void save(@RequestBody PostRequestDto requestDto) {
        postService.save(requestDto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody PostRequestDto request){
        postService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        postService.deleteById(id);
    }

    @PutMapping("/pin/{id}")
    public void updatePin(@PathVariable Long id) { postService.updatePin(id); }
}