package com.example.journal.domain.user.present.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class UpdateIntroRequest {

    @NotBlank
    @Size(max = 30, message = "Intro는 30자 이하여야합니다.")
    private String intro;
}
