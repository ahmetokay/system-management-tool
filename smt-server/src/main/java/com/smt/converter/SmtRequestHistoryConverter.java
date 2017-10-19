package com.smt.converter;

import com.core.tr.converter.BaseAbstractConverter;
import com.smt.dto.SmtRequestHistoryDto;
import com.smt.entity.SmtRequestHistory;
import org.springframework.stereotype.Component;

/**
 * @author bocal
 */
@Component
public class SmtRequestHistoryConverter extends
    BaseAbstractConverter<SmtRequestHistoryDto, SmtRequestHistory> {

  @Override
  protected void doConvertToDto(SmtRequestHistoryDto dto, SmtRequestHistory entity) {
    dto.setTime(entity.getTime());
    dto.setStatus(entity.getStatus());
    dto.setStatusMessage(entity.getStatusMessage());
  }

  @Override
  protected void doConvertToEntity(SmtRequestHistory entity, SmtRequestHistoryDto dto) {
    entity.setTime(dto.getTime());
    entity.setStatus(dto.getStatus());
    entity.setStatusMessage(dto.getStatusMessage());
  }
}