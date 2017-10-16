package com.smt.manager;

import com.smt.entity.SmtRequestNotification;
import com.smt.repository.SmtRequestNotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(readOnly = true)
public class SmtRequestNotificationManagerImpl implements SmtRequestNotificationManager {

    private SmtRequestNotificationRepository requestNotificationRepository;

    @Autowired
    public SmtRequestNotificationManagerImpl(SmtRequestNotificationRepository requestNotificationRepository) {
        this.requestNotificationRepository = requestNotificationRepository;
    }

    @Override
    public SmtRequestNotification create(SmtRequestNotification requestNotification) {
        return requestNotificationRepository.save(requestNotification);
    }
}