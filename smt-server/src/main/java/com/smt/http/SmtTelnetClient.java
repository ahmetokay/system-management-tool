package com.smt.http;

import com.smt.entity.SmtRequest;
import com.smt.exception.SmtConnectException;
import com.smt.exception.SmtException;
import com.smt.exception.SmtUnknownHostException;
import com.smt.util.UrlUtil;
import java.io.IOException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.apache.commons.net.telnet.TelnetClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SmtTelnetClient {

  private Logger logger = LoggerFactory.getLogger(SmtTelnetClient.class);

  public void telnet(SmtRequest smtRequest) throws SmtException {
    try {
      String url = UrlUtil.extractHost(smtRequest.getUrl());
      int port = UrlUtil.extractPort(smtRequest.getUrl());

      InetAddress address = InetAddress.getByName(url);
      if (address != null) {
        TelnetClient telnetClient = new TelnetClient();
        try {
          telnetClient.connect(address.getHostAddress(), port);
          telnetClient.disconnect();

          logger.info("Telnet to " + smtRequest.getUrl() + " was success");
        } catch (ConnectException ce) {
          throw new SmtConnectException("Could not connect to server",
              HttpURLConnection.HTTP_NOT_FOUND);
        } catch (UnknownHostException e) {
          throw new SmtUnknownHostException("Unknown host", HttpURLConnection.HTTP_NOT_FOUND);
        } catch (IOException e) {
          throw new SmtException("Error connecting to server", HttpURLConnection.HTTP_NOT_FOUND);
        }
      }
    } catch (UnknownHostException e) {
      logger.error(e.getMessage(), e);
    }
  }
}