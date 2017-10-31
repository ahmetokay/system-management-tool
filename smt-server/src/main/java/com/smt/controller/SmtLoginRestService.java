package com.smt.controller;

import com.smt.dto.SmtUserDto;
import com.smt.exception.SmtException;
import com.smt.exception.SmtLoginException;
import com.smt.exception.SmtUserNotFoundException;
import com.smt.config.SmtTokenConfig;
import com.smt.security.TokenManager;
import com.smt.service.SmtLoginService;
import java.util.UUID;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SmtLoginRestService {

  private SmtLoginService smtLoginService;

  private TokenManager tokenManager;

  @Autowired
  public SmtLoginRestService(SmtLoginService smtLoginService, TokenManager tokenManager) {
    this.smtLoginService = smtLoginService;
    this.tokenManager = tokenManager;
  }

  //TODO set token as cookie
  @RequestMapping(value = "/smt_login", method = RequestMethod.POST)
  public ResponseEntity<SmtUserDto> create(@RequestParam("email") String email,
      @RequestParam("password") String password, HttpServletResponse response) {
    try {
      String digestPassword = DigestUtils.sha256Hex(password);
      SmtUserDto userDto = smtLoginService.login(email, digestPassword);
      String token = UUID.randomUUID().toString();

      // add token to cache system
      tokenManager.put(token, userDto);

      // add token as cookie
      response.addCookie(new Cookie(SmtTokenConfig.TOKEN_KEY, token));
      return new ResponseEntity<>(userDto, HttpStatus.OK);
    } catch (SmtException e) {
      if (e instanceof SmtUserNotFoundException) {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
      } else if (e instanceof SmtLoginException) {
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
      }

      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}