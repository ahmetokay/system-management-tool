package com.smt.manager;

import com.smt.entity.SmtUser;
import com.smt.exception.SmtException;

public interface SmtLoginManager {

  SmtUser login(String email, String password) throws SmtException;
}