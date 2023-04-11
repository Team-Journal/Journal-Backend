package com.example.journal.global.error.exception;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {
    USER_NOT_FOUND(404, "USER-404-1", "User Not Found"),
    USER_ALREADY_JOINED(409, "USER-409-1", "User Already Joined"),
    INVALID_JWT(401, "JWT-401-1", "Invalid Jwt"),
    EXPIRED_JWT(401, "JWT-401-2", "Expired JWT"),
    PASSWORD_NOT_MATCH(401, "AUTH-401-1", "Password Not Match");

    private final int status;
    private final String code;
    private final String message;
}
