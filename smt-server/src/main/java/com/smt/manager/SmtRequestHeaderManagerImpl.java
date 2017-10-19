package com.smt.manager;

import com.smt.entity.SmtRequestHeader;
import com.smt.repository.SmtRequestHeaderRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(readOnly = true)
public class SmtRequestHeaderManagerImpl implements SmtRequestHeaderManager {

  private String SELECT_QUERY = "SELECT t FROM SmtRequestHeader t WHERE t.isActive=true and t.smtRequest=%s";

  private SmtRequestHeaderRepository requestHeaderRepository;

  @Autowired
  public SmtRequestHeaderManagerImpl(SmtRequestHeaderRepository requestHeaderRepository) {
    this.requestHeaderRepository = requestHeaderRepository;
  }

  @Override
  @Transactional
  public SmtRequestHeader create(SmtRequestHeader requestHeader) {
    return requestHeaderRepository.save(requestHeader);
  }

  @Override
  public List<SmtRequestHeader> list(Long requestId) {
    return requestHeaderRepository.query(String.format(SELECT_QUERY, requestId));
  }
}