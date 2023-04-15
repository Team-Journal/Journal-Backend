package com.example.journal.domain.post.exception;

import com.example.journal.global.error.exception.ErrorCode;
import com.example.journal.global.error.exception.ProjectException;

public class PostNotFoundException extends ProjectException {
    public static final PostNotFoundException EXCEPTION =
        new PostNotFoundException();

    private PostNotFoundException(){
        super(ErrorCode.POST_NOT_FOUND);
    }
}
