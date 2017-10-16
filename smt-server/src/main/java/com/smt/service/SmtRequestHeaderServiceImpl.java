package com.smt.service;

import com.smt.converter.SmtRequestHeaderConverter;
import com.smt.dto.SmtRequestHeaderDto;
import com.smt.entity.SmtRequestHeader;
import com.smt.manager.SmtRequestHeaderManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SmtRequestHeaderServiceImpl implements SmtRequestHeaderService {

    private SmtRequestHeaderConverter requestHeaderConverter;

    private SmtRequestHeaderManager requestHeaderManager;

    @Autowired
    public SmtRequestHeaderServiceImpl(SmtRequestHeaderConverter requestHeaderConverter,
                                       SmtRequestHeaderManager requestHeaderManager) {
        this.requestHeaderConverter = requestHeaderConverter;
        this.requestHeaderManager = requestHeaderManager;
    }

    @Override
    public SmtRequestHeaderDto create(SmtRequestHeaderDto requestHeaderDto) {
        SmtRequestHeader smtRequestHeader = requestHeaderManager.create(requestHeaderConverter.convertToEntity(requestHeaderDto));
        return requestHeaderConverter.convertToDto(smtRequestHeader);
    }
}