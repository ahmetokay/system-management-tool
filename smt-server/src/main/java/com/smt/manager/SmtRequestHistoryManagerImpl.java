package com.smt.manager;

import com.smt.entity.SmtRequestHistory;
import com.smt.repository.SmtRequestHistoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(readOnly = true)
public class SmtRequestHistoryManagerImpl implements SmtRequestHistoryManager {

  private String SELECT_QUERY = "SELECT t FROM SmtRequestHistory t WHERE t.isActive=true and t.smtRequest=%s";

  private SmtRequestHistoryRepository requestHistoryRepository;

  @Autowired
  public SmtRequestHistoryManagerImpl(SmtRequestHistoryRepository requestHistoryRepository) {
    this.requestHistoryRepository = requestHistoryRepository;
  }

  @Override
  @Transactional
  public SmtRequestHistory create(SmtRequestHistory requestHistory) {
    return requestHistoryRepository.save(requestHistory);
  }

  @Override
  public List<SmtRequestHistory> list(Long requestId) {
    return requestHistoryRepository.query(String.format(SELECT_QUERY, requestId));
  }
}