package com.smt.manager;

import com.smt.entity.SmtRequestRecovery;
import com.smt.repository.SmtRequestRecoveryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(readOnly = true)
public class SmtRequestRecoveryManagerImpl implements SmtRequestRecoveryManager {

  private String SELECT_QUERY = "SELECT t FROM SmtRequestRecovery t WHERE t.isActive=true and t.smtRequest=%s";

  private SmtRequestRecoveryRepository requestRecoveryRepository;

  @Autowired
  public SmtRequestRecoveryManagerImpl(SmtRequestRecoveryRepository requestRecoveryRepository) {
    this.requestRecoveryRepository = requestRecoveryRepository;
  }

  @Override
  @Transactional
  public SmtRequestRecovery create(SmtRequestRecovery requestRecovery) {
    return requestRecoveryRepository.save(requestRecovery);
  }

  @Override
  public List<SmtRequestRecovery> list(Long requestId) {
    return requestRecoveryRepository.query(String.format(SELECT_QUERY, requestId));
  }
}