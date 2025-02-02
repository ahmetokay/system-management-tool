package com.smt.service;

import com.smt.converter.SmtRequestRecoveryConverter;
import com.smt.dto.SmtRequestRecoveryDto;
import com.smt.entity.SmtRequest;
import com.smt.entity.SmtRequestRecovery;
import com.smt.manager.SmtRequestRecoveryManager;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SmtRequestRecoveryServiceImpl implements SmtRequestRecoveryService {

  private SmtRequestRecoveryConverter requestRecoveryConverter;

  private SmtRequestRecoveryManager requestRecoveryManager;

  @Autowired
  public SmtRequestRecoveryServiceImpl(SmtRequestRecoveryConverter requestRecoveryConverter,
      SmtRequestRecoveryManager requestRecoveryManager) {
    this.requestRecoveryConverter = requestRecoveryConverter;
    this.requestRecoveryManager = requestRecoveryManager;
  }

  @Override
  public SmtRequestRecoveryDto create(SmtRequestRecoveryDto requestRecoveryDto, Long requestId) {
    SmtRequestRecovery smtRequestRecovery = requestRecoveryConverter
        .convertToEntity(requestRecoveryDto);

    SmtRequest smtRequest = new SmtRequest();
    smtRequest.setPkid(requestId);
    smtRequestRecovery.setSmtRequest(smtRequest);

    smtRequestRecovery = requestRecoveryManager.create(smtRequestRecovery);
    return requestRecoveryConverter.convertToDto(smtRequestRecovery);
  }

  @Override
  public List<SmtRequestRecoveryDto> list(Long requestId) {
    List<SmtRequestRecovery> requestRecoveryList = requestRecoveryManager.list(requestId);
    return requestRecoveryConverter.convertToDtoList(requestRecoveryList);
  }
}