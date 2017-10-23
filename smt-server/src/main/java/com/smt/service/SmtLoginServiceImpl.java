package com.smt.service;

import com.smt.converter.SmtUserConverter;
import com.smt.dto.SmtUserDto;
import com.smt.exception.SmtException;
import com.smt.manager.SmtLoginManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SmtLoginServiceImpl implements SmtLoginService {

  private SmtUserConverter smtUserConverter;

  private SmtLoginManager smtLoginManager;

  @Autowired
  public SmtLoginServiceImpl(SmtUserConverter smtUserConverter, SmtLoginManager smtLoginManager) {
    this.smtUserConverter = smtUserConverter;
    this.smtLoginManager = smtLoginManager;
  }

  @Override
  public SmtUserDto login(String username, String password) throws SmtException {
    return smtUserConverter.convertToDto(smtLoginManager.login(username, password));
  }
}