package com.smt.converter;

import com.core.tr.converter.BaseAbstractConverter;
import com.smt.dto.SmtRequestHistoryDto;
import com.smt.entity.SmtRequestHistory;
import org.springframework.stereotype.Component;

/**
 * @author bocal
 */
@Component
public class SmtRequestHistoryConverter extends BaseAbstractConverter<SmtRequestHistoryDto, SmtRequestHistory> {

    @Override
    protected void doConvertToDto(SmtRequestHistoryDto dto, SmtRequestHistory entity) {
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        dto.setStatusMessage(entity.getStatusMessage());
    }

    @Override
    protected void doConvertToEntity(SmtRequestHistory entity, SmtRequestHistoryDto dto) {
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        entity.setStatusMessage(dto.getStatusMessage());
    }
}