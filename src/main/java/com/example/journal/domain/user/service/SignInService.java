package com.example.journal.domain.user.service;

import com.example.journal.domain.user.domain.User;
import com.example.journal.domain.user.domain.repository.UserRepository;
import com.example.journal.domain.user.exception.PasswordMisMatchException;
import com.example.journal.domain.user.exception.UserNotFoundException;
import com.example.journal.domain.user.present.dto.request.SignInRequestDto;
import com.example.journal.domain.user.present.dto.response.TokenResponse;
import com.example.journal.global.security.jwt.JwtTokenProvider;
import io.jsonwebtoken.Jwt;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SignInService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional(readOnly = true)
    public TokenResponse signIn(SignInRequestDto request){
        User user = userRepository.findByAccountId(request.getAccountId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        System.out.println(request.getAccountId());
        System.out.println(user.getAccountId());

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw PasswordMisMatchException.EXCEPTION;
        }

        String access = jwtTokenProvider.generateAccessToken(request.getAccountId());

        String refresh = jwtTokenProvider.generateRefreshToken(request.getAccountId());

        return TokenResponse.builder()
                .accessToken(access)
                .refreshToken(refresh)
                .authority(user.getAuthority())
                .build();
    }
}