package com.example.journal.domain.email.service;

import com.example.journal.domain.email.present.dto.request.EmailRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService{

    private final JavaMailSender emailSender;

    public static final String ePw = createKey();

    private MimeMessage createMessage(String to) throws Exception{
        System.out.println("보내는 대상 : "+ to);
        System.out.println("인증 번호 : " + ePw);
        MimeMessage message = emailSender.createMimeMessage();

        message.addRecipients(Message.RecipientType.TO, to);
        message.setSubject("이메일 인증 테스트");

        String msg = "";
        msg+= "<div style='margin:20px;'>";
        msg+= "<h1> 안녕하세요 공유몽입니다. </h1>";
        msg+= "<br>";
        msg+= "<p>아래 코드를 복사해 입력해주세요<p>";
        msg+= "<br>";
        msg+= "<p>감사합니다.<p>";
        msg+= "<br>";
        msg+= "<div align='center' style='border:1px solid black; font-family:verdana';>";
        msg+= "<h3 style='color:blue;'>회원가입 인증 코드입니다.</h3>";
        msg+= "<div style='font-size:130%'>";
        msg+= "CODE : <strong>";
        msg+= ePw+"</strong><div><br/> ";
        msg+= "</div>";
        message.setText(msg, "utf-8", "html");
        message.setFrom(new InternetAddress("subenmoom50@gmail.com", "공유몽"));

        return message;
    }

    public static String createKey(){
        StringBuffer key = new StringBuffer();
        Random rnd = new Random();

        for(int i = 0; i<8; i++){
            int index = rnd.nextInt(3);

            switch (index){
                case 0:
                    key.append((char)((int)(rnd.nextInt(26)) + 97));
                    break;
                case 1:
                    key.append((char)((int)(rnd.nextInt(26)) + 65));
                    break;
                case 2:
                    key.append(rnd.nextInt(10));
                    break;
            }
        }
        return key.toString();
    }

    @Override
    public String sendSimpleMessage(EmailRequestDto request) throws Exception {

        String email = request.getEmail();
        MimeMessage message = createMessage(email);
        try {
            emailSender.send(message);
        } catch (MailException es){
            es.printStackTrace();
            throw new IllegalArgumentException();
        }
        return ePw;
    }
}