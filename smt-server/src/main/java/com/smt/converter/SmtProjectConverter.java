package com.smt.converter;

import com.core.tr.converter.BaseAbstractConverter;
import com.smt.dto.SmtProjectDto;
import com.smt.entity.SmtProject;
import org.springframework.stereotype.Component;

/**
 * @author bocal
 */

@Component
public class SmtProjectConverter extends BaseAbstractConverter<SmtProjectDto, SmtProject> {

  @Override
  protected void doConvertToDto(SmtProjectDto dto, SmtProject entity) {
    dto.setName(entity.getName());
    dto.setDescription(entity.getDescription());
  }

  @Override
  protected void doConvertToEntity(SmtProject entity, SmtProjectDto dto) {
    entity.setName(dto.getName());
    entity.setDescription(dto.getDescription());
  }

}
