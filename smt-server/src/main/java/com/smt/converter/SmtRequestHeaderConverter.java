package com.smt.converter;

import com.core.tr.converter.BaseAbstractConverter;
import com.smt.dto.SmtRequestDto;
import com.smt.dto.SmtRequestHeaderDto;
import com.smt.entity.SmtRequest;
import com.smt.entity.SmtRequestHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * @author bocal
 */
@Component
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SmtRequestHeaderConverter extends
    BaseAbstractConverter<SmtRequestHeaderDto, SmtRequestHeader> {

  private SmtRequestConverter smtRequestConverter;

  @Autowired
  public SmtRequestHeaderConverter(SmtRequestConverter smtRequestConverter) {
    this.smtRequestConverter = smtRequestConverter;
  }

  @Override
  protected void doConvertToDto(SmtRequestHeaderDto dto, SmtRequestHeader entity) {
    dto.setKey(entity.getKey());
    dto.setValue(entity.getValue());

    //TODO burada recursive olarak icice giriyor ve yamisiyor :))
//    SmtRequest smtRequest = entity.getSmtRequest();
//    if (smtRequest != null) {
//      dto.setSmtRequest(smtRequestConverter.convertToDto(smtRequest));
//    }
  }

  @Override
  protected void doConvertToEntity(SmtRequestHeader entity, SmtRequestHeaderDto dto) {
    entity.setKey(dto.getKey());
    entity.setValue(dto.getValue());

    SmtRequestDto smtRequest = dto.getSmtRequest();
    if (smtRequest != null) {
      entity.setSmtRequest(smtRequestConverter.convertToEntity(smtRequest));
    }
  }
}