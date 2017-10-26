package com.smt.service;

import com.smt.converter.SmtUserConverter;
import com.smt.dto.SmtUserDto;
import com.smt.entity.SmtUser;
import com.smt.exception.SmtException;
import com.smt.manager.SmtUserManager;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SmtUserServiceImpl implements SmtUserService {

  private SmtUserConverter smtUserConverter;

  private SmtUserManager smtUserManager;

  @Autowired
  public SmtUserServiceImpl(SmtUserConverter smtUserConverter, SmtUserManager smtUserManager) {
    this.smtUserConverter = smtUserConverter;
    this.smtUserManager = smtUserManager;
  }

  @Override
  public SmtUserDto create(SmtUserDto userDto) throws SmtException {
    SmtUser smtUser = smtUserManager.create(smtUserConverter.convertToEntity(userDto));
    return smtUserConverter.convertToDto(smtUser);
  }

  @Override
  public List<SmtUserDto> list() {
    return smtUserConverter.convertToDtoList(smtUserManager.list());
  }
}