package com.smt.test;

import java.net.InetAddress;

public class TestApp {

  public static void main(String[] args) {
    try {
      InetAddress address = InetAddress.getByName("213.136.91.105");
      boolean reachable = address.isReachable(5000);

      System.out.println("Is host reachable? " + reachable);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
