package com.smt.converter;

import com.core.tr.converter.BaseAbstractConverter;
import com.smt.dto.*;
import com.smt.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author bocal
 */
@Component
public class SmtRequestConverter extends BaseAbstractConverter<SmtRequestDto, SmtRequest> {

    private SmtRequestRecoveryConverter smtRequestRecoveryConverter;

    private SmtRequestHistoryConverter smtRequestHistoryConverter;

    private SmtRequestNotificationConverter smtRequestNotificationConverter;

    private SmtRequestHeaderConverter smtRequestHeaderConverter;

    private SmtRequestTypeConverter smtRequestTypeConverter;

    @Autowired
    public SmtRequestConverter() {
    }

    @Override
    protected void doConvertToDto(SmtRequestDto dto, SmtRequest entity) {
        dto.setUrl(entity.getUrl());
        dto.setBody(entity.getBody());
        dto.setRefreshTime(entity.getRefreshTime());
        dto.setTryCount(entity.getTryCount());

        SmtRequestRecovery smtRequestRecovery = entity.getSmtRequestRecovery();
        if (smtRequestRecovery != null) {
            dto.setSmtRequestRecovery(smtRequestRecoveryConverter.convertToDto(smtRequestRecovery));
        }

        List<SmtRequestHistory> smtRequestHistoryList = entity.getSmtRequestHistoryList();
        if (smtRequestHistoryList != null) {
            dto.setSmtRequestHistoryList(smtRequestHistoryConverter.convertToDtoList(smtRequestHistoryList));
        }

        List<SmtRequestNotification> smtRequestNotificationList = entity.getSmtRequestNotificationList();
        if (smtRequestNotificationList != null) {
            dto.setSmtRequestNotificationList(smtRequestNotificationConverter.convertToDtoList(smtRequestNotificationList));
        }

        List<SmtRequestHeader> smtRequestHeaderList = entity.getSmtRequestHeaderList();
        if (smtRequestHeaderList != null) {
            dto.setSmtRequestHeaderList(smtRequestHeaderConverter.convertToDtoList(smtRequestHeaderList));
        }

        SmtRequestType smtRequestType = entity.getSmtRequestType();
        if (smtRequestType != null) {
            dto.setSmtRequestType(smtRequestTypeConverter.convertToDto(smtRequestType));
        }
    }

    @Override
    protected void doConvertToEntity(SmtRequest entity, SmtRequestDto dto) {
        entity.setUrl(dto.getUrl());
        entity.setBody(dto.getBody());
        entity.setRefreshTime(dto.getRefreshTime());
        entity.setTryCount(dto.getTryCount());

        SmtRequestRecoveryDto smtRequestRecoveryDto = dto.getSmtRequestRecovery();
        if (smtRequestRecoveryDto != null) {
            entity.setSmtRequestRecovery(smtRequestRecoveryConverter.convertToEntity(smtRequestRecoveryDto));
        }

        List<SmtRequestHistoryDto> smtRequestHistoryList = dto.getSmtRequestHistoryList();
        if (smtRequestHistoryList != null) {
            entity.setSmtRequestHistoryList(smtRequestHistoryConverter.convertToEntityList(smtRequestHistoryList));
        }

        List<SmtRequestNotificationDto> smtRequestNotificationList = dto.getSmtRequestNotificationList();
        if (smtRequestNotificationList != null) {
            entity.setSmtRequestNotificationList(smtRequestNotificationConverter.convertToEntityList(smtRequestNotificationList));
        }

        List<SmtRequestHeaderDto> smtRequestHeaderList = dto.getSmtRequestHeaderList();
        if (smtRequestHeaderList != null) {
            entity.setSmtRequestHeaderList(smtRequestHeaderConverter.convertToEntityList(smtRequestHeaderList));
        }

        SmtRequestTypeDto smtRequestType = dto.getSmtRequestType();
        if (smtRequestType != null) {
            entity.setSmtRequestType(smtRequestTypeConverter.convertToEntity(smtRequestType));
        }
    }
}