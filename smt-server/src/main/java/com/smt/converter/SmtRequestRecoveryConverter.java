package com.smt.converter;

import com.core.tr.converter.BaseAbstractConverter;
import com.smt.dto.SmtRequestDto;
import com.smt.dto.SmtRequestRecoveryDto;
import com.smt.entity.SmtRequest;
import com.smt.entity.SmtRequestRecovery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author bocal
 */
@Component
public class SmtRequestRecoveryConverter extends BaseAbstractConverter<SmtRequestRecoveryDto, SmtRequestRecovery> {

    private SmtRequestConverter smtRequestConverter;

    @Autowired
    @Lazy
    public SmtRequestRecoveryConverter(SmtRequestConverter smtRequestConverter) {
        this.smtRequestConverter = smtRequestConverter;
    }

    @Override
    protected void doConvertToDto(SmtRequestRecoveryDto dto, SmtRequestRecovery entity) {
        dto.setIp(entity.getIp());
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        dto.setRunScript(entity.getRunScript());

        SmtRequest smtRequest = entity.getSmtRequest();
        if (smtRequest != null) {
            dto.setSmtRequest(smtRequestConverter.convertToDto(smtRequest));
        }
    }

    @Override
    protected void doConvertToEntity(SmtRequestRecovery entity, SmtRequestRecoveryDto dto) {
        entity.setIp(dto.getIp());
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity.setRunScript(dto.getRunScript());

        SmtRequestDto smtRequest = dto.getSmtRequest();
        if (smtRequest != null) {
            entity.setSmtRequest(smtRequestConverter.convertToEntity(smtRequest));
        }
    }
}