package com.example.journal.domain.user.present;

import com.example.journal.domain.user.present.dto.request.SignInRequestDto;
import com.example.journal.domain.user.present.dto.request.SignUpRequestDto;
import com.example.journal.domain.user.present.dto.request.UpdateIntroRequest;
import com.example.journal.domain.user.present.dto.request.UpdatePasswordRequest;
import com.example.journal.domain.user.present.dto.response.TokenResponse;
import com.example.journal.domain.user.service.SignInService;
import com.example.journal.domain.user.service.SignupService;
import com.example.journal.domain.user.service.UserSettingService;
import lombok.RequiredArgsConstructor;
import org.hibernate.sql.Update;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final SignupService signupService;
    private final SignInService signInService;
    private final UserSettingService userSettingService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void signUp(@RequestBody @Valid SignUpRequestDto request) {
        signupService.signup(request);
    }

    @PostMapping("/signin")
    public TokenResponse signIn(@RequestBody @Valid SignInRequestDto request){
        return signInService.signIn(request);
    }

    @PutMapping("/intro")
    public void updateIntro(@RequestBody @Valid UpdateIntroRequest request) {
        userSettingService.IntroUpdate(request);
    }

    @PutMapping("/password")
    public void updatePass(@RequestBody @Valid UpdatePasswordRequest request){
        userSettingService.passwordUpdate(request);
    }
}
