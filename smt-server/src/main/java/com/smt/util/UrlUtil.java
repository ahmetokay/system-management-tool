package com.smt.util;

import java.net.URI;
import java.net.URISyntaxException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UrlUtil {

  private static Logger logger = LoggerFactory.getLogger(UrlUtil.class);

  public static String extractHost(String url) {
    URI uri = createURI(url);
    if (uri == null) {
      return null;
    }
    String domain = uri.getHost();
    return domain.startsWith("www.") ? domain.substring(4) : domain;
  }

  public static int extractPort(String url) {
    URI uri = createURI(url);
    if (uri == null) {
      return -1;
    }

    if (uri.getPort() == -1) {
      return 80;
    }

    return uri.getPort();
  }

  private static URI createURI(String url) {
    try {
      URI uri = new URI(url);
      return uri;
    } catch (URISyntaxException e) {
      logger.error(e.getMessage(), e);
    }
    return null;
  }
}