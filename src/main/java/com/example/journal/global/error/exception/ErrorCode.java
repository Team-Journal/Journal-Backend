package com.example.journal.global.error.exception;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {
    USER_NOT_FOUND(404, "USER-404-1", "User Not Found"),
    USER_ALREADY_JOINED(409, "USER-409-1", "User Already Joined");

    private final int status;
    private final String code;
    private final String message;
}
