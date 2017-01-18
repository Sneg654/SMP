package com.smp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Created by Sergey_Stefoglo on 1/18/2017.
 */
@Service("mailService")
public class MailServiceImpl implements MailService {

    @Autowired
    JavaMailSender mailSender;

    @Override
    public void sendEmail(Object object) {



        MimeMessagePreparator preparator = getMessagePreparator();

        try {
            mailSender.send(preparator);
            System.out.println("Message Send...Hurrey");
        } catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private MimeMessagePreparator getMessagePreparator() {

        MimeMessagePreparator preparator = new MimeMessagePreparator() {

            public void prepare(MimeMessage mimeMessage) throws Exception {
                mimeMessage.setFrom("customerserivces@yourshop.com");
                mimeMessage.setRecipient(Message.RecipientType.TO,
                        new InternetAddress("sneg654@mail.ru"));
                mimeMessage.setText("Dear "
                        + ", thank you for placing order. Your order id is " +  ".");
                mimeMessage.setSubject("Your order on Demoapp");
            }
        };
        return preparator;
    }

}
