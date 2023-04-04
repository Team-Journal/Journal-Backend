package com.example.journal.domain.user.present.dto.request;

import com.example.journal.global.enums.Authority;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class SignUpRequestDto {

    @NotBlank(message = "email은 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    private String email;

    @NotBlank(message = "accountId는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @Size(min = 4, max = 15, message = "accountId는 4자 이상, 15자 이하여야 합니다.")
    private String accountId;


    @NotBlank(message = "password는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @Size(min = 8, max = 20, message = "password는 8자 이상, 20자 이하여야 합니다.")
    private String password;

}
