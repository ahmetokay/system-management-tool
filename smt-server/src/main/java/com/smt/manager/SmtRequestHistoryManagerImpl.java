package com.smt.manager;

import com.smt.entity.SmtRequestHistory;
import com.smt.repository.SmtRequestHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(readOnly = true)
public class SmtRequestHistoryManagerImpl implements SmtRequestHistoryManager {

    private SmtRequestHistoryRepository requestHistoryRepository;

    @Autowired
    public SmtRequestHistoryManagerImpl(SmtRequestHistoryRepository requestHistoryRepository) {
        this.requestHistoryRepository = requestHistoryRepository;
    }

    @Override
    @Transactional
    public SmtRequestHistory create(SmtRequestHistory requestHistory) {
        return requestHistoryRepository.save(requestHistory);
    }
}