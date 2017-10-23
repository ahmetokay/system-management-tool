package com.smt.manager;

import com.smt.entity.SmtUser;
import com.smt.exception.SmtLoginException;
import com.smt.exception.SmtException;
import com.smt.exception.SmtUserNotFoundException;
import com.smt.repository.SmtUserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(readOnly = true)
public class SmtLoginManagerImpl implements SmtLoginManager {

  private String LOGIN_QUERY = "SELECT t FROM SmtUser t WHERE t.isActive=true and t.email='%s' and t.password='%s'";

  private String SELECT_QUERY = "SELECT t FROM SmtUser t WHERE t.isActive=true and t.email='%s'";

  private SmtUserRepository smtUserRepository;

  @Autowired
  public SmtLoginManagerImpl(SmtUserRepository smtUserRepository) {
    this.smtUserRepository = smtUserRepository;
  }

  @Override
  public SmtUser login(String email, String password) throws SmtException {
    List<SmtUser> smtUserList = smtUserRepository.query(String.format(SELECT_QUERY, email));
    if (smtUserList.size() == 0) {
      throw new SmtUserNotFoundException();
    }

    List<SmtUser> userList = smtUserRepository.query(String.format(LOGIN_QUERY, email, password));
    if (userList.size() == 0) {
      throw new SmtLoginException();
    }
    return userList.get(0);
  }
}