package com.qrcode.majorproject.tevonwallace.qrcode;

import android.os.AsyncTask;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Created by TevonWallace on 8/12/17.
 */

public class SendEmail extends AsyncTask<Void, Void, String> {
    private Session session;
    private String recipient;
    private String subject;
    private String messageBody;

    public SendEmail() {
        this.session = null;

        this.configureProperties();
    }

    public void configureProperties() {
        Properties props = new Properties();

        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        this.session = Session.getDefaultInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("ttest6432@gmail.com", "Uhg-8nd-JSG-hhG");
            }
        });
    }

    @Override
    protected String doInBackground(Void... voids) {
        String emailSent = "Email Was Not Sent";

        try {
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress("ttest6432@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            message.setSubject(subject);
            message.setContent(messageBody, "text/html; charset=utf-8");

            Transport.send(message);

            emailSent = "Email was sent";
        }
        catch(MessagingException e) {
            e.printStackTrace();
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        return emailSent;
    }

    public void setEmailData(String recipient, String subject, String messageBody) {
        this.recipient = recipient;
        this.subject = subject;
        this.messageBody = messageBody;
    }
}