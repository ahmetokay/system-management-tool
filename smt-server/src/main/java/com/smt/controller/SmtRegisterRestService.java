package com.smt.controller;

import com.smt.dto.SmtUserDto;
import com.smt.dto.SmtUserRoleDto;
import com.smt.exception.SmtException;
import com.smt.service.SmtUserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SmtRegisterRestService {

  private SmtUserService smtUserService;

  @Autowired
  public SmtRegisterRestService(SmtUserService smtUserService) {
    this.smtUserService = smtUserService;
  }

  @RequestMapping(value = "/smt_register", method = RequestMethod.POST)
  public ResponseEntity<SmtUserDto> create(@RequestParam("email") String email,
      @RequestParam("password") String password) {
    SmtUserDto smtUserDto = new SmtUserDto();
    smtUserDto.setIsactive(true);
    smtUserDto.setEmail(email);
    smtUserDto.setPassword(DigestUtils.sha256Hex(password));

    //set user role
    SmtUserRoleDto smtUserRoleDto = new SmtUserRoleDto();
    smtUserRoleDto.setPkid(1L);
    smtUserDto.setSmtUserRole(smtUserRoleDto);

    try {
      smtUserDto = smtUserService.create(smtUserDto);
      return new ResponseEntity<>(smtUserDto, HttpStatus.OK);
    } catch (SmtException e) {
      return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
  }
}