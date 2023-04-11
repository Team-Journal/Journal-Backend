package com.example.journal.domain.user.exception;

import com.example.journal.global.error.exception.ErrorCode;
import com.example.journal.global.error.exception.ProjectException;

public class PasswordMisMatchException extends ProjectException {
    public static final PasswordMisMatchException EXCEPTION =
            new PasswordMisMatchException();

    public PasswordMisMatchException(){
        super(ErrorCode.PASSWORD_NOT_MATCH);
    }
}