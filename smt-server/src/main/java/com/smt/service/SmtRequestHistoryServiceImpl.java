package com.smt.service;

import com.smt.converter.SmtRequestHistoryConverter;
import com.smt.dto.SmtRequestHistoryDto;
import com.smt.entity.SmtRequest;
import com.smt.entity.SmtRequestHistory;
import com.smt.manager.SmtRequestHistoryManager;
import java.util.List;
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
  public SmtRequestHistoryDto create(SmtRequestHistoryDto requestHistoryDto, Long requestId) {
    SmtRequestHistory smtRequestHistory = requestHistoryConverter
        .convertToEntity(requestHistoryDto);

    SmtRequest smtRequest = new SmtRequest();
    smtRequest.setPkid(requestId);
    smtRequestHistory.setSmtRequest(smtRequest);

    smtRequestHistory = requestHistoryManager.create(smtRequestHistory);
    return requestHistoryConverter.convertToDto(smtRequestHistory);
  }

  @Override
  public List<SmtRequestHistoryDto> list(Long requestId) {
    List<SmtRequestHistory> requestHistoryList = requestHistoryManager.list(requestId);
    return requestHistoryConverter.convertToDtoList(requestHistoryList);
  }
}