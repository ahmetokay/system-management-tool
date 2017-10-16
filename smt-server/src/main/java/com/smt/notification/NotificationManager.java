package com.smt.notification;

import com.smt.dto.SmtRequestNotificationDto;

public interface NotificationManager {

  void notify(SmtRequestNotificationDto requestNotificationDto, String message);
}