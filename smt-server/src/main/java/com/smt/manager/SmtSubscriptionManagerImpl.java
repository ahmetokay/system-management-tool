package com.smt.manager;

import com.smt.entity.SmtSubscription;
import com.smt.repository.SmtSubscriptionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(readOnly = true)
public class SmtSubscriptionManagerImpl implements SmtSubscriptionManager {

  private SmtSubscriptionRepository smtSubscriptionRepository;

  @Autowired
  public SmtSubscriptionManagerImpl(SmtSubscriptionRepository smtSubscriptionRepository) {
    this.smtSubscriptionRepository = smtSubscriptionRepository;
  }

  @Override
  @Transactional
  public SmtSubscription create(SmtSubscription subscription) {
    return smtSubscriptionRepository.save(subscription);
  }

  @Override
  public List<SmtSubscription> list() {
    return smtSubscriptionRepository.findAll();
  }
}