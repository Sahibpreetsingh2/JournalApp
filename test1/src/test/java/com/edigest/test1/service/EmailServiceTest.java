package com.edigest.test1.service;

import com.edigest.test1.Service.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTest {

     @Autowired
    private EmailService emailService;

     @Test
void testSendMail(){
    emailService.sendEmail("sahibdhiman8966@gmail.com",
            "Testing java mail sender",
            "Hi, I am send mail to you");
}
}
