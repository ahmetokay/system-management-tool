package com.smt.converter;

import com.core.tr.converter.BaseAbstractConverter;
import com.smt.dto.SmtRequestNotificationDto;
import com.smt.entity.SmtRequestNotification;
import org.springframework.stereotype.Component;

/**
 * @author bocal
 */
@Component
public class SmtRequestNotificationConverter extends BaseAbstractConverter<SmtRequestNotificationDto, SmtRequestNotification> {

    @Override
    protected void doConvertToDto(SmtRequestNotificationDto dto, SmtRequestNotification entity) {
        dto.setEmail(entity.getEmail());
        dto.setSms(entity.getSms());
        dto.setRestart(entity.getRestart());
    }

    @Override
    protected void doConvertToEntity(SmtRequestNotification entity, SmtRequestNotificationDto dto) {
        entity.setEmail(dto.getEmail());
        entity.setSms(dto.getSms());
        entity.setRestart(dto.getRestart());
    }
}