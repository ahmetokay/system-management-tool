package com.smt.security;

import com.smt.dto.SmtUserDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class TokenManagerImpl implements TokenManager {

  //TODO burada tutulan veri yapisi degisecek. Token belirli bir sure durduktan sonra silinmesi gerekiyor.
  private List<String> tokenList;

  public TokenManagerImpl() {
    this.tokenList = new ArrayList<>();
  }

  @Override
  public boolean check(String token) {
    return tokenList.contains(token);
  }

  @Override
  public void update(String token) {
    tokenList.add(token);
  }

  @Override
  public void put(String token, SmtUserDto userDto) {
    tokenList.add(token);

//    cacheManager.setCacheNames();
//    cacheManager.setCacheNames(Arrays.asList());
//
//
//    cacheManager = new ConcurrentMapCacheManager() {
//
//      @Override
//      protected Cache createConcurrentMapCache(final String name) {
//        return new ConcurrentMapCache(name,
//            CacheBuilder.newBuilder().expireAfterWrite(30, TimeUnit.MINUTES).maximumSize(100)
//                .build().asMap(), false);
//      }
//    };
//
//    cacheManager.
//
//        tokenMap.put(token, userDto);
  }
}