package com.example.new_project.fragment;


import javax.mail.*;

import androidx.recyclerview.widget.RecyclerView;
import javax.mail.Session;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMailSender {


    private static final String SMTP_HOST = "smtp.gmail.com";
    private static final String SMTP_PORT = "465";
    private static final String EMAIL = "code.x.novas@gmail.com";
    private static final String PASSWORD = "codexnovas#0912@lyt";

    public static void sendEmail(String recipient, String subject, String body) {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", SMTP_HOST);
        properties.put("mail.smtp.port", SMTP_PORT);

        Session session = Session.getInstance(properties);
        session.setDebug(true); // Enable debug mode for logging



        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(EMAIL));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message,EMAIL,PASSWORD);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static void sendEmail(String reportContent) {
    }
}




