package com.smt.service;

import com.smt.converter.SmtRequestNotificationConverter;
import com.smt.dto.SmtRequestNotificationDto;
import com.smt.entity.SmtRequest;
import com.smt.entity.SmtRequestNotification;
import com.smt.manager.SmtRequestNotificationManager;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SmtRequestNotificationServiceImpl implements SmtRequestNotificationService {

  private SmtRequestNotificationConverter requestNotificationConverter;

  private SmtRequestNotificationManager requestNotificationManager;

  @Autowired
  public SmtRequestNotificationServiceImpl(
      SmtRequestNotificationConverter requestNotificationConverter,
      SmtRequestNotificationManager requestNotificationManager) {
    this.requestNotificationConverter = requestNotificationConverter;
    this.requestNotificationManager = requestNotificationManager;
  }

  @Override
  public SmtRequestNotificationDto create(SmtRequestNotificationDto requestNotificationDto,
      Long requestId) {
    SmtRequestNotification smtRequestNotification = requestNotificationConverter
        .convertToEntity(requestNotificationDto);

    SmtRequest smtRequest = new SmtRequest();
    smtRequest.setPkid(requestId);
    smtRequestNotification.setSmtRequest(smtRequest);

    smtRequestNotification = requestNotificationManager.create(smtRequestNotification);
    return requestNotificationConverter.convertToDto(smtRequestNotification);
  }

  @Override
  public List<SmtRequestNotificationDto> list(Long requestId) {
    List<SmtRequestNotification> requestNotificationList = requestNotificationManager
        .list(requestId);
    return requestNotificationConverter.convertToDtoList(requestNotificationList);
  }
}