package com.smt.manager;

import com.smt.entity.SmtUser;
import com.smt.exception.SmtException;
import java.util.List;

public interface SmtUserManager {

  SmtUser create(SmtUser user) throws SmtException;

  List<SmtUser> list();
}