package com.smt.service;

import com.smt.converter.SmtRequestConverter;
import com.smt.dto.SmtRequestDto;
import com.smt.entity.SmtRequest;
import com.smt.manager.SmtRequestManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SmtRequestServiceImpl implements SmtRequestService {

  private SmtRequestConverter requestConverter;

  private SmtRequestManager requestManager;

  @Autowired
  public SmtRequestServiceImpl(SmtRequestConverter requestConverter,
      SmtRequestManager requestManager) {
    this.requestConverter = requestConverter;
    this.requestManager = requestManager;
  }

  @Override
  public SmtRequestDto create(SmtRequestDto request) {
    SmtRequest smtRequest = requestManager.create(requestConverter.convertToEntity(request));
    return requestConverter.convertToDto(smtRequest);
  }
}