package com.smt.notification;

import com.smt.dto.SmtRequestNotificationDto;
import com.smt.util.EmailUtil;
import com.smt.util.SmsUtil;
import org.springframework.stereotype.Component;

@Component
public class NotificationManagerImpl implements NotificationManager {

  private final String DELIMETER = ",";

  @Override
  public void notify(SmtRequestNotificationDto requestNotificationDto, String message) {
    // check and send email
    String emailVal = requestNotificationDto.getEmail();
    if (emailVal != null) {

      String[] emailArray = emailVal.split(DELIMETER);
      for (String email : emailArray) {
        EmailUtil.send(email, "Subject", message);
      }
    }

    // check and send sms
    String smsVal = requestNotificationDto.getSms();
    if (smsVal != null) {
      String[] smsArray = emailVal.split(DELIMETER);
      for (String sms : smsArray) {
        SmsUtil.send(sms, message);
      }
    }
  }
}