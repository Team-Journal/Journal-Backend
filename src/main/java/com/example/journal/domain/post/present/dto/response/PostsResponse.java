package com.example.journal.domain.post.present.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class PostsResponse {
    private Long id;
    private String title;
    private String content;
    private String author;
}
