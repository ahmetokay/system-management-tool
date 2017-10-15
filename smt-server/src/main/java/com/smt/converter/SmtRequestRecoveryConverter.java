package com.smt.converter;

import com.core.tr.converter.BaseAbstractConverter;
import com.smt.dto.SmtRequestRecoveryDto;
import com.smt.entity.SmtRequestRecovery;
import org.springframework.stereotype.Component;

/**
 * @author bocal
 */
@Component
public class SmtRequestRecoveryConverter extends BaseAbstractConverter<SmtRequestRecoveryDto, SmtRequestRecovery> {

    @Override
    protected void doConvertToDto(SmtRequestRecoveryDto dto, SmtRequestRecovery entity) {
        dto.setIp(entity.getIp());
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        dto.setRunScript(entity.getRunScript());
    }

    @Override
    protected void doConvertToEntity(SmtRequestRecovery entity, SmtRequestRecoveryDto dto) {
        entity.setIp(dto.getIp());
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity.setRunScript(dto.getRunScript());
    }
}