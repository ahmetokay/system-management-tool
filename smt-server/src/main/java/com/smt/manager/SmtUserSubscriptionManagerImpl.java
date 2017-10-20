package com.smt.manager;

import com.smt.entity.SmtUserSubscription;
import com.smt.repository.SmtUserSubscriptionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(readOnly = true)
public class SmtUserSubscriptionManagerImpl implements SmtUserSubscriptionManager {

  private String SELECT_QUERY = "SELECT t FROM SmtUserSubscription t WHERE t.isActive=true and t.smtUser=%s";

  private SmtUserSubscriptionRepository smtUserSubscriptionRepository;

  @Autowired
  public SmtUserSubscriptionManagerImpl(
      SmtUserSubscriptionRepository smtUserSubscriptionRepository) {
    this.smtUserSubscriptionRepository = smtUserSubscriptionRepository;
  }

  @Override
  @Transactional
  public SmtUserSubscription create(SmtUserSubscription userSubscription) {
    return smtUserSubscriptionRepository.save(userSubscription);
  }

  @Override
  public List<SmtUserSubscription> list(Long userId) {
    return smtUserSubscriptionRepository.query(String.format(SELECT_QUERY, userId));
  }
}