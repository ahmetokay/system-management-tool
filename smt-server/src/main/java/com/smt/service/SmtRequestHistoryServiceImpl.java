package com.smt.service;

import com.smt.converter.SmtRequestHistoryConverter;
import com.smt.dto.SmtRequestHistoryDto;
import com.smt.entity.SmtRequestHistory;
import com.smt.manager.SmtRequestHistoryManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SmtRequestHistoryServiceImpl implements SmtRequestHistoryService {

  private SmtRequestHistoryConverter requestHistoryConverter;

  private SmtRequestHistoryManager requestHistoryManager;

  @Autowired
  public SmtRequestHistoryServiceImpl(SmtRequestHistoryConverter requestHistoryConverter,
      SmtRequestHistoryManager requestHistoryManager) {
    this.requestHistoryConverter = requestHistoryConverter;
    this.requestHistoryManager = requestHistoryManager;
  }

  @Override
  public SmtRequestHistoryDto create(SmtRequestHistoryDto requestHistoryDto) {
    SmtRequestHistory smtRequestHistory = requestHistoryManager
        .create(requestHistoryConverter.convertToEntity(requestHistoryDto));
    return requestHistoryConverter.convertToDto(smtRequestHistory);
  }
}