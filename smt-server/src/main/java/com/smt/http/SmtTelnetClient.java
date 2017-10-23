package com.smt.http;

import com.smt.entity.SmtRequest;
import com.smt.exception.SmtConnectException;
import com.smt.exception.SmtException;
import com.smt.exception.SmtUnknownHostException;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.apache.commons.net.telnet.TelnetClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SmtTelnetClient {

  private Logger logger = LoggerFactory.getLogger(SmtTelnetClient.class);

  public void telnet(SmtRequest smtRequest) throws SmtException {
    try {
      InetAddress address = InetAddress.getByName(smtRequest.getUrl());
      if (address != null) {
        TelnetClient telnetClient = new TelnetClient();
        try {
          telnetClient.connect(address.getHostAddress(), 80);
          telnetClient.disconnect();
        } catch (ConnectException ce) {
          throw new SmtConnectException("Could not connect to server");
        } catch (UnknownHostException e) {
          throw new SmtUnknownHostException("Unknown host");
        } catch (IOException e) {
          throw new SmtException("Error connecting to server");
        }
      }
    } catch (UnknownHostException e) {
      logger.error(e.getMessage(), e);
    }
  }
}