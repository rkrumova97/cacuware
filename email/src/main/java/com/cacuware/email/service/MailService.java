package com.cacuware.email.service;

import com.cacuware.email.api.dto.EmailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.mail.internet.MimeMessage;

@Service
public class MailService {
    @Autowired
    private JavaMailSender sender;

    public void sendEmail(@RequestBody EmailDto emailDto) {
        MimeMessage message = sender.createMimeMessage();

        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(message, true);
            helper.setTo(emailDto.getEmail());
            helper.setText(emailDto.getText(), true);
            helper.setSubject(emailDto.getSubject());
            helper.addAttachment(emailDto.getFileName(), emailDto.getFile());
        } catch (Exception e) {
            e.printStackTrace();
        }

        sender.send(message);
    }
}

