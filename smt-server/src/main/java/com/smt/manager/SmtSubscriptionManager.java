package com.smt.manager;

import com.smt.entity.SmtSubscription;
import java.util.List;

public interface SmtSubscriptionManager {

  SmtSubscription create(SmtSubscription subscription);

  List<SmtSubscription> list();
}