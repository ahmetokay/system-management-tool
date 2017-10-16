package com.smt.converter;

import com.core.tr.converter.BaseAbstractConverter;
import com.smt.dto.SmtRequestDto;
import com.smt.dto.SmtRequestTypeDto;
import com.smt.entity.SmtRequest;
import com.smt.entity.SmtRequestType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * @author bocal
 */
@Component
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SmtRequestTypeConverter extends
    BaseAbstractConverter<SmtRequestTypeDto, SmtRequestType> {

  private SmtRequestConverter smtRequestConverter;

  @Autowired
  public SmtRequestTypeConverter(SmtRequestConverter smtRequestConverter) {
    this.smtRequestConverter = smtRequestConverter;
  }

  @Override
  protected void doConvertToDto(SmtRequestTypeDto dto, SmtRequestType entity) {
    dto.setName(entity.getName());
    dto.setDescription(entity.getDescription());

    SmtRequest smtRequest = entity.getSmtRequest();
    if (smtRequest != null) {
      dto.setSmtRequest(smtRequestConverter.convertToDto(smtRequest));
    }
  }

  @Override
  protected void doConvertToEntity(SmtRequestType entity, SmtRequestTypeDto dto) {
    entity.setName(dto.getName());
    entity.setDescription(dto.getDescription());

    SmtRequestDto smtRequest = dto.getSmtRequest();
    if (smtRequest != null) {
      entity.setSmtRequest(smtRequestConverter.convertToEntity(smtRequest));
    }
  }
}