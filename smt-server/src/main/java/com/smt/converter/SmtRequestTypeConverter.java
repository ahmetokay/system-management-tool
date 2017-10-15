package com.smt.converter;

import com.core.tr.converter.BaseAbstractConverter;
import com.smt.dto.SmtRequestTypeDto;
import com.smt.entity.SmtRequestType;
import org.springframework.stereotype.Component;

/**
 * @author bocal
 */
@Component
public class SmtRequestTypeConverter extends BaseAbstractConverter<SmtRequestTypeDto, SmtRequestType> {

    @Override
    protected void doConvertToDto(SmtRequestTypeDto dto, SmtRequestType entity) {
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
    }

    @Override
    protected void doConvertToEntity(SmtRequestType entity, SmtRequestTypeDto dto) {
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
    }
}