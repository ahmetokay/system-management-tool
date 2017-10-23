package com.smt.controller;

import com.smt.dto.SmtUserDto;
import com.smt.exception.LoginException;
import com.smt.exception.SmtException;
import com.smt.exception.UserNotFoundException;
import com.smt.security.SmtTokenConfig;
import com.smt.service.SmtLoginService;
import java.util.UUID;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/smt_login")
public class SmtLoginRestService {

  private SmtLoginService smtLoginService;

  @Autowired
  public SmtLoginRestService(SmtLoginService smtLoginService) {
    this.smtLoginService = smtLoginService;
  }

  //TODO set token as cookie
  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public ResponseEntity<SmtUserDto> create(@RequestParam("email") String email,
      @RequestParam("password") String password, HttpServletResponse response) {
    try {
      SmtUserDto userDto = smtLoginService.login(email, password);
      response.addCookie(new Cookie(SmtTokenConfig.TOKEN_KEY, UUID.randomUUID().toString()));
      return new ResponseEntity<>(userDto, HttpStatus.OK);
    } catch (SmtException e) {
      if (e instanceof UserNotFoundException) {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
      } else if (e instanceof LoginException) {
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
      }

      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}