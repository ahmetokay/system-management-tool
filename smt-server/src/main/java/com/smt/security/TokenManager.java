package com.smt.security;

import com.smt.dto.SmtUserDto;

public interface TokenManager {

  boolean check(String token);

  void update(String token);

  void put(String token, SmtUserDto userDto);
}