package com.smt.controller;

import com.smt.dto.SmtUserDto;
import com.smt.exception.SmtException;
import com.smt.service.SmtUserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/smt_user")
public class SmtUserRestService {

  private SmtUserService smtUserService;

  @Autowired
  public SmtUserRestService(SmtUserService smtUserService) {
    this.smtUserService = smtUserService;
  }

  @RequestMapping(value = "/create", method = RequestMethod.POST)
  public ResponseEntity<SmtUserDto> create(@RequestBody SmtUserDto userDto) {
    try {
      return new ResponseEntity<>(smtUserService.create(userDto), HttpStatus.OK);
    } catch (SmtException e) {
      return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
  }

  @RequestMapping(value = "/list", method = RequestMethod.POST)
  public ResponseEntity<List<SmtUserDto>> list() {
    return new ResponseEntity<>(smtUserService.list(), HttpStatus.OK);
  }
}