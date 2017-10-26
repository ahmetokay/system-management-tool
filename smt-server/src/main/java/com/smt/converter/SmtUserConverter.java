package com.smt.converter;

import com.core.tr.converter.BaseAbstractConverter;
import com.smt.dto.SmtProjectDto;
import com.smt.dto.SmtUserDto;
import com.smt.dto.SmtUserRoleDto;
import com.smt.dto.SmtUserSubscriptionDto;
import com.smt.entity.SmtProject;
import com.smt.entity.SmtUser;
import com.smt.entity.SmtUserRole;
import com.smt.entity.SmtUserSubscription;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SmtUserConverter extends BaseAbstractConverter<SmtUserDto, SmtUser> {

  private SmtUserRoleConverter smtUserRoleConverter;

  private SmtUserSubscriptionConverter smtUserSubscriptionConverter;

  private SmtProjectConverter smtProjectConverter;

  @Autowired
  public SmtUserConverter(SmtUserRoleConverter smtUserRoleConverter,
      SmtUserSubscriptionConverter smtUserSubscriptionConverter,
      SmtProjectConverter smtProjectConverter) {
    this.smtUserRoleConverter = smtUserRoleConverter;
    this.smtUserSubscriptionConverter = smtUserSubscriptionConverter;
    this.smtProjectConverter = smtProjectConverter;
  }

  @Override
  protected void doConvertToDto(SmtUserDto dto, SmtUser entity) {
    dto.setName(entity.getName());
    dto.setSurname(entity.getSurname());
    dto.setEmail(entity.getEmail());
    dto.setAddress(entity.getAddress());
    dto.setCity(entity.getCity());
    dto.setCountry(entity.getCountry());

    SmtUserRole smtUserRole = entity.getSmtUserRole();
    if (smtUserRole != null) {
      dto.setSmtUserRole(smtUserRoleConverter.convertToDto(smtUserRole));
    }

    SmtUserSubscription smtUserSubscription = entity.getSmtUserSubscription();
    if (smtUserSubscription != null) {
      dto.setSmtUserSubscription(smtUserSubscriptionConverter.convertToDto(smtUserSubscription));
    }

    List<SmtProject> smtProjectList = entity.getSmtProjectList();
    if (smtProjectList != null) {
      dto.setSmtProjectList(smtProjectConverter.convertToDtoList(smtProjectList));
    }
  }

  @Override
  protected void doConvertToEntity(SmtUser entity, SmtUserDto dto) {
    entity.setName(dto.getName());
    entity.setSurname(dto.getSurname());
    entity.setEmail(dto.getEmail());
    entity.setPassword(dto.getPassword());
    entity.setAddress(dto.getAddress());
    entity.setCity(dto.getCity());
    entity.setCountry(dto.getCountry());

    SmtUserRoleDto smtUserRole = dto.getSmtUserRole();
    if (smtUserRole != null) {
      entity.setSmtUserRole(smtUserRoleConverter.convertToEntity(smtUserRole));
    }

    SmtUserSubscriptionDto smtUserSubscription = dto.getSmtUserSubscription();
    if (smtUserSubscription != null) {
      entity.setSmtUserSubscription(
          smtUserSubscriptionConverter.convertToEntity(smtUserSubscription));
    }

    List<SmtProjectDto> smtProjectList = dto.getSmtProjectList();
    if (smtProjectList != null) {
      entity.setSmtProjectList(smtProjectConverter.convertToEntityList(smtProjectList));
    }
  }
}