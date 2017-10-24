package com.smt.notification;

import com.smt.entity.SmtRequest;
import com.smt.entity.SmtRequestHistory;
import com.smt.exception.SmtException;
import com.smt.http.SmtPingClient;
import com.smt.http.SmtTelnetClient;
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
      int statusCode = 200;
      String statusMessage = "SUCCESS";
      try {
        SmtTelnetClient smtTelnetClient = new SmtTelnetClient();
        smtTelnetClient.telnet(smtRequest);

        SmtPingClient smtPingClient = new SmtPingClient();
        smtPingClient.ping(smtRequest);

//        SmtHttpClient httpClient = new SmtHttpClient();
//        httpClient.sendRequest(smtRequest);
      } catch (SmtException e) {
        statusCode = e.getCode();
        statusMessage = e.getMessage();
      } catch (Exception e) {
        logger.error(e.getMessage(), e);
      } finally {
        SmtRequestHistory smtRequestHistory = new SmtRequestHistory();
        smtRequestHistory.setSmtRequest(smtRequest);
        smtRequestHistory.setStatus(statusCode);
        smtRequestHistory.setStatusMessage(statusMessage);
        smtRequestHistory.setTime(new Timestamp(System.currentTimeMillis()));
        smtRequestHistoryRepository.save(smtRequestHistory);
      }
    }
  }
}