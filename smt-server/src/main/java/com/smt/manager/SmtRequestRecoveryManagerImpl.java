package com.smt.manager;

import com.smt.entity.SmtRequestRecovery;
import com.smt.repository.SmtRequestRecoveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(readOnly = true)
public class SmtRequestRecoveryManagerImpl implements SmtRequestRecoveryManager {

    private SmtRequestRecoveryRepository requestRecoveryRepository;

    @Autowired
    public SmtRequestRecoveryManagerImpl(SmtRequestRecoveryRepository requestRecoveryRepository) {
        this.requestRecoveryRepository = requestRecoveryRepository;
    }

    @Override
    public SmtRequestRecovery create(SmtRequestRecovery requestRecovery) {
        return requestRecoveryRepository.save(requestRecovery);
    }
}