package com.smt.converter;

import com.core.tr.converter.BaseAbstractConverter;
import com.smt.dto.SmtRequestHeaderDto;
import com.smt.entity.SmtRequestHeader;
import org.springframework.stereotype.Component;

/**
 * @author bocal
 */
@Component
public class SmtRequestHeaderConverter extends BaseAbstractConverter<SmtRequestHeaderDto, SmtRequestHeader> {

    @Override
    protected void doConvertToDto(SmtRequestHeaderDto dto, SmtRequestHeader entity) {
        dto.setKey(entity.getKey());
        dto.setValue(entity.getValue());
    }

    @Override
    protected void doConvertToEntity(SmtRequestHeader entity, SmtRequestHeaderDto dto) {
        entity.setKey(dto.getKey());
        entity.setValue(dto.getValue());
    }
}