package com.smt.manager;

import com.smt.entity.SmtRequest;
import com.smt.repository.SmtRequestRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(readOnly = true)
public class SmtRequestManagerImpl implements SmtRequestManager {

  private String SELECT_QUERY = "SELECT t FROM SmtRequest t WHERE t.isActive=true and t.smtProject=%s";

  private SmtRequestRepository smtRequestRepository;

  @Autowired
  public SmtRequestManagerImpl(SmtRequestRepository smtRequestRepository) {
    this.smtRequestRepository = smtRequestRepository;
  }

  @Override
  @Transactional
  public SmtRequest create(SmtRequest request) {
    return smtRequestRepository.save(request);
  }

  @Override
  public List<SmtRequest> list(Long projectId) {
    return smtRequestRepository.query(String.format(SELECT_QUERY, projectId));
  }
}