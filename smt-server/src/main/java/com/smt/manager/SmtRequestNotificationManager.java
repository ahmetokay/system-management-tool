package com.smt.manager;

import com.smt.entity.SmtRequestNotification;
import java.util.List;

public interface SmtRequestNotificationManager {

  SmtRequestNotification create(SmtRequestNotification requestNotification);

  List<SmtRequestNotification> list(Long requestId);
}