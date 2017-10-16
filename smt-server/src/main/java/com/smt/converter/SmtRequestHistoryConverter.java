package com.smt.converter;

import com.core.tr.converter.BaseAbstractConverter;
import com.smt.dto.SmtRequestDto;
import com.smt.dto.SmtRequestHistoryDto;
import com.smt.entity.SmtRequest;
import com.smt.entity.SmtRequestHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * @author bocal
 */
@Component
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SmtRequestHistoryConverter extends
    BaseAbstractConverter<SmtRequestHistoryDto, SmtRequestHistory> {

  private SmtRequestConverter smtRequestConverter;

  @Autowired
  public SmtRequestHistoryConverter(SmtRequestConverter smtRequestConverter) {
    this.smtRequestConverter = smtRequestConverter;
  }

  @Override
  protected void doConvertToDto(SmtRequestHistoryDto dto, SmtRequestHistory entity) {
    dto.setName(entity.getName());
    dto.setStatus(entity.getStatus());
    dto.setStatusMessage(entity.getStatusMessage());

    SmtRequest smtRequest = entity.getSmtRequest();
    if (smtRequest != null) {
      dto.setSmtRequest(smtRequestConverter.convertToDto(smtRequest));
    }
  }

  @Override
  protected void doConvertToEntity(SmtRequestHistory entity, SmtRequestHistoryDto dto) {
    entity.setName(dto.getName());
    entity.setStatus(dto.getStatus());
    entity.setStatusMessage(dto.getStatusMessage());

    SmtRequestDto smtRequest = dto.getSmtRequest();
    if (smtRequest != null) {
      entity.setSmtRequest(smtRequestConverter.convertToEntity(smtRequest));
    }
  }
}