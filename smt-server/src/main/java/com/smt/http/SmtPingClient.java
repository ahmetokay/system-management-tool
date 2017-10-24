package com.smt.http;

import com.smt.entity.SmtRequest;
import com.smt.exception.SmtException;
import com.smt.exception.SmtPingException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SmtPingClient {

  private Logger logger = LoggerFactory.getLogger(SmtPingClient.class);

  public void ping(SmtRequest smtRequest) throws SmtException {
    try {
      URL url = new URL(smtRequest.getUrl());
      HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
      urlConn.setConnectTimeout(1000 * 2); // mTimeout is in seconds
      urlConn.connect();
      if (urlConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
        logger.info("Ping to " + smtRequest.getUrl() + " was success");
      } else {
        throw new SmtPingException();
      }
    } catch (MalformedURLException e1) {
      throw new SmtPingException("MalformedURLException");
    } catch (IOException e) {
      throw new SmtPingException("IOException");
    }
  }
}