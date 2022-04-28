package com.fabio.mockemailservice.services;

import com.fabio.mockemailservice.entities.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import java.util.Date;

public abstract class AbstractEmailService implements EmailService{

    @Value("${default.sender}")
    private String sender;

    @Override
    public void sendPersonConfirmationEmail(Person person) {
        SimpleMailMessage sm = prepareSimpleMailMessagePerson(person);
        sendEmail(sm);
    }


    private SimpleMailMessage prepareSimpleMailMessagePerson(Person person) {
        SimpleMailMessage sm = new SimpleMailMessage();
        sm.setTo(person.getEmail());
        sm.setFrom(sender);
        sm.setSubject("Happy Birthday "+ person.getNome());
        sm.setSentDate(new Date(System.currentTimeMillis()));
        sm.setText(person.toString());
        return sm;
    }


}
