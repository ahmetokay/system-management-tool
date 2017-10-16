package com.smt.converter;

import com.core.tr.converter.BaseAbstractConverter;
import com.smt.dto.SmtRequestDto;
import com.smt.dto.SmtRequestNotificationDto;
import com.smt.entity.SmtRequest;
import com.smt.entity.SmtRequestNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author bocal
 */
@Component
public class SmtRequestNotificationConverter extends BaseAbstractConverter<SmtRequestNotificationDto, SmtRequestNotification> {

    private SmtRequestConverter smtRequestConverter;

    @Autowired
    @Lazy
    public SmtRequestNotificationConverter(SmtRequestConverter smtRequestConverter) {
        this.smtRequestConverter = smtRequestConverter;
    }

    @Override
    protected void doConvertToDto(SmtRequestNotificationDto dto, SmtRequestNotification entity) {
        dto.setEmail(entity.getEmail());
        dto.setSms(entity.getSms());
        dto.setRestart(entity.getRestart());

        SmtRequest smtRequest = entity.getSmtRequest();
        if (smtRequest != null) {
            dto.setSmtRequest(smtRequestConverter.convertToDto(smtRequest));
        }
    }

    @Override
    protected void doConvertToEntity(SmtRequestNotification entity, SmtRequestNotificationDto dto) {
        entity.setEmail(dto.getEmail());
        entity.setSms(dto.getSms());
        entity.setRestart(dto.getRestart());

        SmtRequestDto smtRequest = dto.getSmtRequest();
        if (smtRequest != null) {
            entity.setSmtRequest(smtRequestConverter.convertToEntity(smtRequest));
        }
    }
}