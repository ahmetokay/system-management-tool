package com.smt.notification;

import com.smt.entity.SmtRequest;
import com.smt.entity.SmtRequestHistory;
import com.smt.http.SmtHttpClient;
import com.smt.repository.SmtRequestHistoryRepository;
import com.smt.repository.SmtRequestRepository;
import java.sql.Timestamp;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RequestManagerImpl implements RequestManager {

  private Logger logger = LoggerFactory.getLogger(RequestManagerImpl.class);

  private String SELECT_QUERY = "SELECT t FROM SmtRequest t WHERE t.isActive=true";

  private SmtRequestRepository smtRequestRepository;

  private SmtRequestHistoryRepository smtRequestHistoryRepository;

  @Autowired
  public RequestManagerImpl(SmtRequestRepository smtRequestRepository,
      SmtRequestHistoryRepository smtRequestHistoryRepository) {
    this.smtRequestRepository = smtRequestRepository;
    this.smtRequestHistoryRepository = smtRequestHistoryRepository;
  }

  @Override
  public void executeRequest() {
    List<SmtRequest> smtRequestList = smtRequestRepository.query(SELECT_QUERY);
    for (SmtRequest smtRequest : smtRequestList) {
      try {
        SmtHttpClient httpClient = new SmtHttpClient();
        httpClient.sendRequest(smtRequest);

        SmtRequestHistory smtRequestHistory = new SmtRequestHistory();
        smtRequestHistory.setSmtRequest(smtRequest);
        smtRequestHistory.setStatus("200");
        smtRequestHistory.setStatusMessage("OK");
        smtRequestHistory.setTime(new Timestamp(System.currentTimeMillis()));
        smtRequestHistoryRepository.save(smtRequestHistory);
      } catch (Exception e) {
        logger.error(e.getMessage());
      }
    }
  }
}