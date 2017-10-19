package com.smt.controller;

import com.smt.dto.SmtRequestNotificationDto;
import com.smt.service.SmtRequestNotificationService;
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
@RequestMapping(value = "/smt_request_notification")
public class SmtRequestNotificationRestService {

  private SmtRequestNotificationService requestNotificationService;

  @Autowired
  public SmtRequestNotificationRestService(
      SmtRequestNotificationService requestNotificationService) {
    this.requestNotificationService = requestNotificationService;
  }

  @RequestMapping(value = "/create", method = RequestMethod.POST)
  public ResponseEntity<SmtRequestNotificationDto> create(
      @RequestBody SmtRequestNotificationDto requestNotificationDto,
      @RequestParam("requestId") Long requestId) {
    return new ResponseEntity<>(
        requestNotificationService.create(requestNotificationDto, requestId), HttpStatus.OK);
  }

  @RequestMapping(value = "/list", method = RequestMethod.POST)
  public ResponseEntity<List<SmtRequestNotificationDto>> list(
      @RequestParam("requestId") Long requestId) {
    return new ResponseEntity<>(requestNotificationService.list(requestId), HttpStatus.OK);
  }
}