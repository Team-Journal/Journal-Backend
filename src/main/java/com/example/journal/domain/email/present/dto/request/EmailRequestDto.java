package com.example.journal.domain.email.present.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class EmailRequestDto {

    @NotBlank(message = "Email은 Null을 허용하지 않습니다.")
    @Email(message = "Email 형식에 맞지 않습니다.")
    private String email;
}
