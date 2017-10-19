package com.smt.controller;

import com.smt.dto.SmtRequestRecoveryDto;
import com.smt.service.SmtRequestRecoveryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
      @RequestBody SmtRequestRecoveryDto requestRecoveryDto,
      @RequestParam("requestId") Long requestId) {
    return new ResponseEntity<>(
        requestRecoveryService.create(requestRecoveryDto, requestId), HttpStatus.OK);
  }

  @RequestMapping(value = "/list", method = RequestMethod.POST)
  public ResponseEntity<List<SmtRequestRecoveryDto>> list(
      @RequestParam("requestId") Long requestId) {
    return new ResponseEntity<>(requestRecoveryService.list(requestId), HttpStatus.OK);
  }
}