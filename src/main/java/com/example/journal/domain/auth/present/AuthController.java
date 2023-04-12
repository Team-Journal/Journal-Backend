package com.example.journal.domain.auth.present;

import com.example.journal.domain.auth.present.dto.UserRefreshTokenResponse;
import com.example.journal.domain.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PutMapping("/refresh")
    public UserRefreshTokenResponse reissue(@RequestHeader("Refresh-Token") String refreshToken){
        return authService.reissue(refreshToken);
    }
}
