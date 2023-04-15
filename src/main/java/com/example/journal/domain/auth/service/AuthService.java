package com.example.journal.domain.auth.service;

import com.example.journal.domain.auth.domain.RefreshToken;
import com.example.journal.domain.auth.domain.repository.RefreshTokenRepository;
import com.example.journal.domain.auth.exception.RefreshTokenNotFoundException;
import com.example.journal.domain.auth.present.dto.UserRefreshTokenResponse;
import com.example.journal.domain.user.domain.User;
import com.example.journal.domain.user.facade.UserFacade;
import com.example.journal.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserFacade userFacade;
    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public UserRefreshTokenResponse reissue(String refreshToken){
        User user = userFacade.getCurrentUser();

        if(!jwtTokenProvider.getTokenBody(refreshToken).get("type").equals("refresh"))
            throw RefreshTokenNotFoundException.EXCEPTION;

        RefreshToken refreshToken1 = refreshTokenRepository.findByToken(refreshToken)
                .orElseThrow(() -> RefreshTokenNotFoundException.EXCEPTION);

        String userAccountId = refreshToken1.getAccountId();

        String newRefreshToken = jwtTokenProvider.generateRefreshToken(userAccountId);
        refreshToken1.updateToken(newRefreshToken);

        String accessToken = jwtTokenProvider.generateAccessToken(userAccountId);

        return UserRefreshTokenResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .authority(user.getAuthority())
                .build();
    }
}
