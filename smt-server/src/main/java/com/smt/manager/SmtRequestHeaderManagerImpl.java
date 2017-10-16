package com.smt.manager;

import com.smt.entity.SmtRequestHeader;
import com.smt.repository.SmtRequestHeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(readOnly = true)
public class SmtRequestHeaderManagerImpl implements SmtRequestHeaderManager {

    private SmtRequestHeaderRepository requestHeaderRepository;

    @Autowired
    public SmtRequestHeaderManagerImpl(SmtRequestHeaderRepository requestHeaderRepository) {
        this.requestHeaderRepository = requestHeaderRepository;
    }

    @Override
    public SmtRequestHeader create(SmtRequestHeader requestHeader) {
        return requestHeaderRepository.save(requestHeader);
    }
}