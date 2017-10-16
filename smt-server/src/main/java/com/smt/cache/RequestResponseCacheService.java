package com.smt.cache;

import com.smt.converter.SmtRequestResponseConverter;
import com.smt.dto.SmtRequestResponseDto;
import com.smt.entity.SmtRequestResponse;
import com.smt.repository.SmtRequestResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@EnableCaching
public class RequestResponseCacheService {

    private SmtRequestResponseRepository smtRequestResponseRepository;

    private SmtRequestResponseConverter smtRequestResponseConverter;

    @Autowired
    public RequestResponseCacheService(SmtRequestResponseRepository smtRequestResponseRepository,
                                       SmtRequestResponseConverter smtRequestResponseConverter) {
        this.smtRequestResponseRepository = smtRequestResponseRepository;
        this.smtRequestResponseConverter = smtRequestResponseConverter;
    }

    @Cacheable(value = "requestResponse")
    public List<SmtRequestResponseDto> getRequestResponseList() {
        List<SmtRequestResponse> requestResponseList = smtRequestResponseRepository.findAll();
        return smtRequestResponseConverter.convertToDtoList(requestResponseList);
    }
}