package com.smt.manager;

import com.smt.entity.SmtRequestNotification;
import com.smt.repository.SmtRequestNotificationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(readOnly = true)
public class SmtRequestNotificationManagerImpl implements SmtRequestNotificationManager {

  private String SELECT_QUERY = "SELECT t FROM SmtRequestNotification t WHERE t.isActive=true and t.smtRequest=%s";

  private SmtRequestNotificationRepository requestNotificationRepository;

  @Autowired
  public SmtRequestNotificationManagerImpl(
      SmtRequestNotificationRepository requestNotificationRepository) {
    this.requestNotificationRepository = requestNotificationRepository;
  }

  @Override
  @Transactional
  public SmtRequestNotification create(SmtRequestNotification requestNotification) {
    return requestNotificationRepository.save(requestNotification);
  }

  @Override
  public List<SmtRequestNotification> list(Long requestId) {
    return requestNotificationRepository.query(String.format(SELECT_QUERY, requestId));
  }
}