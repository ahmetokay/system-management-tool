package com.smt.manager;

import com.smt.entity.SmtUserSubscription;
import java.util.List;

public interface SmtUserSubscriptionManager {

  SmtUserSubscription create(SmtUserSubscription userSubscription);

  List<SmtUserSubscription> list(Long userId);
}