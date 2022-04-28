package com.fabio.mockemailservice.services;

import com.fabio.mockemailservice.entities.Person;
import org.springframework.mail.SimpleMailMessage;

public interface EmailService {

    void sendPersonConfirmationEmail(Person person);

    void sendEmail(SimpleMailMessage msg);
}
