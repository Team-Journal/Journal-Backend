package com.example.journal.domain.post.exception;

import com.example.journal.global.error.exception.ErrorCode;
import com.example.journal.global.error.exception.ProjectException;

public class PostAccessDeniedException extends ProjectException {
    public final static PostAccessDeniedException EXCEPTION =
            new PostAccessDeniedException();

    private PostAccessDeniedException(){
        super(ErrorCode.POST_ACCESS_DENIED);
    }
}
