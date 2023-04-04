package com.example.journal.domain.user.service;

import com.example.journal.domain.user.domain.User;
import com.example.journal.domain.user.domain.repository.UserRepository;
import com.example.journal.domain.user.exception.AlreadyJoinedException;
import com.example.journal.domain.user.present.dto.request.SignUpRequestDto;
import com.example.journal.global.enums.Authority;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignupService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public void signup(SignUpRequestDto request){
        if(userRepository.findByAccountId(request.getAccountId()).isPresent())
             throw AlreadyJoinedException.EXCEPTION;


        userRepository.save(
                User.builder()
                        .email(request.getEmail())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .accountId(request.getAccountId())
                        .authority(Authority.USER)
                        .intro("")
                        .build()
        );
    }
}
