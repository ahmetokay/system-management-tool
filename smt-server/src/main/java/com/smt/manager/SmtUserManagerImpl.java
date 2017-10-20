package com.smt.manager;

import com.smt.entity.SmtUser;
import com.smt.repository.SmtUserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(readOnly = true)
public class SmtUserManagerImpl implements SmtUserManager {

  private SmtUserRepository smtUserRepository;

  @Autowired
  public SmtUserManagerImpl(SmtUserRepository smtUserRepository) {
    this.smtUserRepository = smtUserRepository;
  }

  @Override
  @Transactional
  public SmtUser create(SmtUser user) {
    return smtUserRepository.save(user);
  }

  @Override
  public List<SmtUser> list() {
    return smtUserRepository.findAll();
  }
}