package com.smt.converter;

import com.core.tr.converter.BaseAbstractConverter;
import com.smt.dto.SmtSubscriptionDto;
import com.smt.dto.SmtUserSubscriptionDto;
import com.smt.entity.SmtSubscription;
import com.smt.entity.SmtUserSubscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SmtUserSubscriptionConverter extends
    BaseAbstractConverter<SmtUserSubscriptionDto, SmtUserSubscription> {

  private SmtSubscriptionConverter smtSubscriptionConverter;

  @Autowired
  public SmtUserSubscriptionConverter(SmtSubscriptionConverter smtSubscriptionConverter) {
    this.smtSubscriptionConverter = smtSubscriptionConverter;
  }

  @Override
  protected void doConvertToDto(SmtUserSubscriptionDto dto, SmtUserSubscription entity) {
    dto.setStartDate(entity.getStartDate());
    dto.setEndDate(entity.getEndDate());

    SmtSubscription smtSubscription = entity.getSmtSubscription();
    if (smtSubscription != null) {
      dto.setSmtSubscription(smtSubscriptionConverter.convertToDto(smtSubscription));
    }
  }

  @Override
  protected void doConvertToEntity(SmtUserSubscription entity, SmtUserSubscriptionDto dto) {
    entity.setStartDate(dto.getStartDate());
    entity.setEndDate(dto.getEndDate());

    SmtSubscriptionDto smtSubscription = dto.getSmtSubscription();
    if (smtSubscription != null) {
      entity.setSmtSubscription(smtSubscriptionConverter.convertToEntity(smtSubscription));
    }
  }
}