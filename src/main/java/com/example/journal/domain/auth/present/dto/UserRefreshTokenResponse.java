package com.example.journal.domain.auth.present.dto;


import com.example.journal.global.enums.Authority;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserRefreshTokenResponse {
    private final String accessToken;
    private final String refreshToken;
    private final Authority authority;
}
