package com.example.journal.domain.user.present.dto.request;

import com.example.journal.domain.user.domain.repository.UserRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class SignInRequestDto {

    @NotBlank(message = "accountId는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @Size(min = 4, max = 15, message = "accountId 는 4자 이상 15자 이하여야 합니다.")
    private String accountId;

    @NotBlank(message = "password는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @Size(min = 8, max = 20, message = "password는 8자 이상 20자 이하여야 합니다.")
    private String password;
}
