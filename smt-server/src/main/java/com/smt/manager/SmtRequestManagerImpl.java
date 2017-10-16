package com.smt.manager;

import com.smt.entity.SmtRequest;
import com.smt.repository.SmtRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(readOnly = true)
public class SmtRequestManagerImpl implements SmtRequestManager {

    private SmtRequestRepository smtRequestRepository;

    @Autowired
    public SmtRequestManagerImpl(SmtRequestRepository smtRequestRepository) {
        this.smtRequestRepository = smtRequestRepository;
    }

    @Override
    @Transactional
    public SmtRequest create(SmtRequest request) {
        return smtRequestRepository.save(request);
    }
}