package com.smt.manager;

import com.smt.entity.SmtUser;
import java.util.List;

public interface SmtUserManager {

  SmtUser create(SmtUser user);

  List<SmtUser> list();
}