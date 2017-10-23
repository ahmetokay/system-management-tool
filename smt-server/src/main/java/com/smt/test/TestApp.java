package com.smt.test;

import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.apache.commons.net.telnet.TelnetClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestApp {

  private static Logger logger = LoggerFactory.getLogger(TestApp.class);

  public static void main(String[] args) {
//    try {
//      InetAddress address = InetAddress.getByName("213.136.91.105");
//      boolean reachable = address.isReachable(5000);
//
//      System.out.println("Is host reachable? " + reachable);
//    } catch (Exception e) {
//      e.printStackTrace();
//    }

//    EmailUtil.send("ahmet.okay@outlook.com", "Konu","Aciklamalar bla bla... Amina goduk mu Bulent baskannn    https://www.youtube.com/watch?v=-FdW7wA4MWY");

    /**
     * PING example
     */
//    try {
//      InetAddress inet = InetAddress.getByName("193.28.255.200");
//      System.out.println(inet.isReachable(5000));
//      System.out.println(inet);
//    } catch (UnknownHostException e) {
//      e.printStackTrace();
//    } catch (IOException e) {
//      e.printStackTrace();
//    }

    /**
     * TELNET example
     */

    TelnetClient telnetClient = new TelnetClient();
    try {
      telnetClient.connect("213.136.91.105", 23);
      telnetClient.disconnect();
    } catch (ConnectException ce) {
      logger.info("Could not connect to server '");
    } catch (UnknownHostException e) {
      logger.error("Unknown host: ");
    } catch (IOException e) {
      logger.error("Error connecting to server: " + " - " + e.getMessage(), e);
    }


  }
}
