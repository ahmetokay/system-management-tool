package com.smt.controller;

import com.smt.dto.SmtRequestRecoveryDto;
import com.smt.service.SmtRequestRecoveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/smt_request_recovery")
public class SmtRequestRecoveryRestService {

  private SmtRequestRecoveryService requestRecoveryService;

  @Autowired
  public SmtRequestRecoveryRestService(SmtRequestRecoveryService requestRecoveryService) {
    this.requestRecoveryService = requestRecoveryService;
  }

  @RequestMapping(value = "/create", method = RequestMethod.POST)
  public ResponseEntity<SmtRequestRecoveryDto> create(
      @RequestBody SmtRequestRecoveryDto requestRecoveryDto) {
    return new ResponseEntity<SmtRequestRecoveryDto>(
        requestRecoveryService.create(requestRecoveryDto), HttpStatus.OK);
  }
}