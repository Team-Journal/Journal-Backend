package com.example.journal.domain.user.present.dto.response;

import com.example.journal.global.enums.Authority;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TokenResponse {
    private final String accessToken;

    private final String refreshToken;
    private final Authority authority;
}
