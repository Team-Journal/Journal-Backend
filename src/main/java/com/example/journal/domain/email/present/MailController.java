package com.example.journal.domain.email.present;

import com.example.journal.domain.email.present.dto.request.EmailRequestDto;
import com.example.journal.domain.email.present.dto.response.EmailResponseDto;
import com.example.journal.domain.email.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
@RequiredArgsConstructor
public class MailController {

    private final EmailService emailService;

    @PostMapping("/email")
    public EmailResponseDto emailConfirm(@RequestBody EmailRequestDto request) throws Exception {
        String confirm = emailService.sendSimpleMessage(request);

        return EmailResponseDto.builder()
                .code(confirm).build();
    }
}