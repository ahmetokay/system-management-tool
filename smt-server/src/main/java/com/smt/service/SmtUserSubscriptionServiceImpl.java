package com.smt.service;

import com.smt.converter.SmtUserSubscriptionConverter;
import com.smt.dto.SmtUserSubscriptionDto;
import com.smt.entity.SmtUser;
import com.smt.entity.SmtUserSubscription;
import com.smt.manager.SmtUserSubscriptionManager;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SmtUserSubscriptionServiceImpl implements SmtUserSubscriptionService {

  private SmtUserSubscriptionConverter smtUserSubscriptionConverter;

  private SmtUserSubscriptionManager smtUserSubscriptionManager;

  @Autowired
  public SmtUserSubscriptionServiceImpl(SmtUserSubscriptionConverter smtUserSubscriptionConverter,
      SmtUserSubscriptionManager smtUserSubscriptionManager) {
    this.smtUserSubscriptionConverter = smtUserSubscriptionConverter;
    this.smtUserSubscriptionManager = smtUserSubscriptionManager;
  }

  @Override
  public SmtUserSubscriptionDto create(SmtUserSubscriptionDto userSubscriptionDto, Long userId) {
    SmtUserSubscription smtUserSubscription = smtUserSubscriptionConverter
        .convertToEntity(userSubscriptionDto);

    SmtUser smtUser = new SmtUser();
    smtUser.setPkid(userId);
    smtUserSubscription.setSmtUser(smtUser);
    smtUserSubscription = smtUserSubscriptionManager.create(smtUserSubscription);

    return smtUserSubscriptionConverter.convertToDto(smtUserSubscription);
  }

  @Override
  public List<SmtUserSubscriptionDto> list(Long userId) {
    List<SmtUserSubscription> userSubscriptionList = smtUserSubscriptionManager.list(userId);
    return smtUserSubscriptionConverter.convertToDtoList(userSubscriptionList);
  }
}