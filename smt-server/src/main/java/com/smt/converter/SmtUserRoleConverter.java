package com.smt.converter;

import com.core.tr.converter.BaseAbstractConverter;
import com.smt.dto.SmtUserRoleDto;
import com.smt.entity.SmtUserRole;
import org.springframework.stereotype.Component;

@Component
public class SmtUserRoleConverter extends BaseAbstractConverter<SmtUserRoleDto, SmtUserRole> {

  @Override
  protected void doConvertToDto(SmtUserRoleDto dto, SmtUserRole entity) {
    dto.setName(entity.getName());
    dto.setDescription(entity.getDescription());
  }

  @Override
  protected void doConvertToEntity(SmtUserRole entity, SmtUserRoleDto dto) {
    entity.setName(dto.getName());
    entity.setDescription(dto.getDescription());
  }
}