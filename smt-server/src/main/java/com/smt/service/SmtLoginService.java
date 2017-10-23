package com.smt.service;

import com.smt.dto.SmtUserDto;
import com.smt.exception.SmtException;

public interface SmtLoginService {

  SmtUserDto login(String username, String password) throws SmtException;
}