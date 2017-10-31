package com.smt.security;

import com.smt.config.CacheConfiguration;
import com.smt.dto.SmtUserDto;
import java.io.IOException;
import java.net.InetSocketAddress;
import net.spy.memcached.MemcachedClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TokenManagerImpl implements TokenManager {

  private Logger logger = LoggerFactory.getLogger(TokenManagerImpl.class);

  private final int CACHE_DURATION = 1000 * 60;

  private CacheConfiguration cacheConfiguration;

  private MemcachedClient client;

  public TokenManagerImpl(CacheConfiguration cacheConfiguration) {
    this.cacheConfiguration = cacheConfiguration;
  }

  @Override
  public boolean check(String token) {
    if (client == null) {
      fillClientObject();
    }

    return client.get(token) != null ? true : false;
  }

  @Override
  public void update(String token) {

  }

  @Override
  public void put(String token, SmtUserDto userDto) {
    if (client == null) {
      fillClientObject();
    }
    client.set(token, CACHE_DURATION, userDto);
  }

  private void fillClientObject() {
    try {
      String host = cacheConfiguration.getHost();
      int port = cacheConfiguration.getPort();
      client = new MemcachedClient(new InetSocketAddress(host, port));
    } catch (IOException e) {
      logger.error(e.getMessage(), e);
    }
  }
}