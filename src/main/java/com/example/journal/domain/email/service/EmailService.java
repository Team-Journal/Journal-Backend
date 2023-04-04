package com.example.journal.domain.email.service;

import com.example.journal.domain.email.present.dto.request.EmailRequestDto;

public interface EmailService {
    String sendSimpleMessage(EmailRequestDto to) throws Exception;
}
