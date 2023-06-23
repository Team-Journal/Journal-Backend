package com.example.journal.domain.post.exception;

import com.example.journal.global.error.exception.ErrorCode;
import com.example.journal.global.error.exception.ProjectException;

public class PinExceededException extends ProjectException {
    public static final PinExceededException EXCEPTION =
            new PinExceededException();

    private PinExceededException() {
        super(ErrorCode.POST_PIN_EXCEEDED);
    }
}
