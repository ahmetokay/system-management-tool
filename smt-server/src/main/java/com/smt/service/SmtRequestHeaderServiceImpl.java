package com.smt.service;

import com.smt.converter.SmtRequestHeaderConverter;
import com.smt.dto.SmtRequestHeaderDto;
import com.smt.entity.SmtRequest;
import com.smt.entity.SmtRequestHeader;
import com.smt.manager.SmtRequestHeaderManager;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SmtRequestHeaderServiceImpl implements SmtRequestHeaderService {

  private SmtRequestHeaderConverter requestHeaderConverter;

  private SmtRequestHeaderManager requestHeaderManager;

  @Autowired
  public SmtRequestHeaderServiceImpl(SmtRequestHeaderConverter requestHeaderConverter,
      SmtRequestHeaderManager requestHeaderManager) {
    this.requestHeaderConverter = requestHeaderConverter;
    this.requestHeaderManager = requestHeaderManager;
  }

  @Override
  public SmtRequestHeaderDto create(SmtRequestHeaderDto requestHeaderDto, Long requestId) {
    SmtRequestHeader smtRequestHeader = requestHeaderConverter.convertToEntity(requestHeaderDto);

    SmtRequest smtRequest = new SmtRequest();
    smtRequest.setPkid(requestId);
    smtRequestHeader.setSmtRequest(smtRequest);
    smtRequestHeader = requestHeaderManager.create(smtRequestHeader);

//    SmtRequestHeader smtRequestHeader = requestHeaderManager.create(requestHeaderConverter.convertToEntity(requestHeaderDto));

    return requestHeaderConverter.convertToDto(smtRequestHeader);
  }

  @Override
  public List<SmtRequestHeaderDto> list(Long requestId) {
    List<SmtRequestHeader> requestHeaderList = requestHeaderManager.list(requestId);
    return requestHeaderConverter.convertToDtoList(requestHeaderList);
  }
}