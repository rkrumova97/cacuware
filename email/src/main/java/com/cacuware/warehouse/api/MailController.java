package com.cacuware.email.api;

import com.cacuware.email.api.dto.EmailDto;
import com.cacuware.email.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MailController {
    @Autowired
    private MailService mailService;

    @PostMapping( "/sendMail" )
    public EmailDto sendEmail(@RequestBody EmailDto emailDto ) {
        mailService.sendEmail( emailDto );
        return emailDto;
    }
}

