package com.smt.util;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmailUtil {

  private static Logger logger = LoggerFactory.getLogger(EmailUtil.class);

  private static final String USERNAME = "system.management.tool@gmail.com";
  private static final String PASSWORD = "Aa123456**";

  public static void send(String to, String subject, String body) {
    Properties props = new Properties();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");

    Session session = Session.getInstance(props,
        new javax.mail.Authenticator() {
          protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(USERNAME, PASSWORD);
          }
        });

    try {
      Message message = new MimeMessage(session);
      message.setFrom(new InternetAddress(USERNAME));
      message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
      message.setSubject(subject);
      message.setText(body);

      Transport.send(message);
    } catch (MessagingException e) {
      logger.error("Error occurred while sending email.");
    }
  }
}