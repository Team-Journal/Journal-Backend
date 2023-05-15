package com.example.journal.domain.post.present.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PostsListResponse {
    List<PostsResponse> postList;
}
