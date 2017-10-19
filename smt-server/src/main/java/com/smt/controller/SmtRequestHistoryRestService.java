package com.smt.controller;

import com.smt.dto.SmtRequestHistoryDto;
import com.smt.service.SmtRequestHistoryService;
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
@RequestMapping(value = "/smt_request_history")
public class SmtRequestHistoryRestService {

  private SmtRequestHistoryService requestHistoryService;

  @Autowired
  public SmtRequestHistoryRestService(SmtRequestHistoryService requestHistoryService) {
    this.requestHistoryService = requestHistoryService;
  }

  @RequestMapping(value = "/create", method = RequestMethod.POST)
  public ResponseEntity<SmtRequestHistoryDto> create(
      @RequestBody SmtRequestHistoryDto requestHistoryDto,
      @RequestParam("requestId") Long requestId) {
    return new ResponseEntity<>(requestHistoryService.create(requestHistoryDto, requestId),
        HttpStatus.OK);
  }

  @RequestMapping(value = "/list", method = RequestMethod.POST)
  public ResponseEntity<List<SmtRequestHistoryDto>> list(
      @RequestParam("requestId") Long requestId) {
    return new ResponseEntity<>(requestHistoryService.list(requestId), HttpStatus.OK);
  }
}