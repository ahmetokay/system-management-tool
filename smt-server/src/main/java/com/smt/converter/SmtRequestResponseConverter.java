package com.smt.converter;

import com.core.tr.converter.BaseAbstractConverter;
import com.smt.dto.SmtRequestResponseDto;
import com.smt.entity.SmtRequestResponse;
import org.springframework.stereotype.Component;

/**
 * @author bocal
 */
@Component
public class SmtRequestResponseConverter extends BaseAbstractConverter<SmtRequestResponseDto, SmtRequestResponse> {

    @Override
    protected void doConvertToDto(SmtRequestResponseDto dto, SmtRequestResponse entity) {
        dto.setStatus(entity.getStatus());
    }

    @Override
    protected void doConvertToEntity(SmtRequestResponse entity, SmtRequestResponseDto dto) {
        entity.setStatus(dto.getStatus());
    }
}