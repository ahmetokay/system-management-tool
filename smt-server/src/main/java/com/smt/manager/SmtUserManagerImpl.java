package com.smt.manager;

import com.smt.entity.SmtUser;
import com.smt.exception.SmtException;
import com.smt.exception.SmtUserAlreadyRegisteredException;
import com.smt.repository.SmtUserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(readOnly = true)
public class SmtUserManagerImpl implements SmtUserManager {

  private String SELECT_QUERY = "SELECT t FROM SmtUser t WHERE t.isActive=true and t.email='%s'";

  private SmtUserRepository smtUserRepository;

  @Autowired
  public SmtUserManagerImpl(SmtUserRepository smtUserRepository) {
    this.smtUserRepository = smtUserRepository;
  }

  @Override
  @Transactional
  public SmtUser create(SmtUser user) throws SmtException {
    String email = user.getEmail();
    List<SmtUser> userList = smtUserRepository.query(String.format(SELECT_QUERY, email));
    if (userList.size() > 0) {
      throw new SmtUserAlreadyRegisteredException();
    }

    return smtUserRepository.save(user);
  }

  @Override
  public List<SmtUser> list() {
    return smtUserRepository.findAll();
  }
}