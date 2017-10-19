package com.smt.service;

import com.smt.dto.SmtRequestNotificationDto;
import java.util.List;

public interface SmtRequestNotificationService {

  SmtRequestNotificationDto create(SmtRequestNotificationDto requestNotificationDto);

  List<SmtRequestNotificationDto> list(Long requestId);
}