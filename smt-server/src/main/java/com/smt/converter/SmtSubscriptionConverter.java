package com.smt.converter;

import com.core.tr.converter.BaseAbstractConverter;
import com.smt.dto.SmtSubscriptionDto;
import com.smt.entity.SmtSubscription;
import org.springframework.stereotype.Component;

@Component
public class SmtSubscriptionConverter extends
    BaseAbstractConverter<SmtSubscriptionDto, SmtSubscription> {

  @Override
  protected void doConvertToDto(SmtSubscriptionDto dto, SmtSubscription entity) {
    dto.setName(entity.getName());
    dto.setDescription(entity.getDescription());
    dto.setProjectSize(entity.getProjectSize());
    dto.setRequestSize(entity.getRequestSize());
  }

  @Override
  protected void doConvertToEntity(SmtSubscription entity, SmtSubscriptionDto dto) {
    entity.setName(dto.getName());
    entity.setDescription(dto.getDescription());
    entity.setProjectSize(dto.getProjectSize());
    entity.setRequestSize(dto.getRequestSize());
  }
}