package com.example.journal.domain.post.present.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class PostRequestDto {
    private String title;
    private String content;
}