package com.smt.controller;

import com.smt.dto.SmtRequestDto;
import com.smt.service.SmtRequestService;
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
@RequestMapping(value = "/smt_request")
public class SmtRequestRestService {

  private SmtRequestService requestService;

  @Autowired
  public SmtRequestRestService(SmtRequestService requestService) {
    this.requestService = requestService;
  }

  @RequestMapping(value = "/create", method = RequestMethod.POST)
  public ResponseEntity<SmtRequestDto> create(@RequestBody SmtRequestDto requestDto,
      @RequestParam("projectId") Long projectId) {
    return new ResponseEntity<>(requestService.create(requestDto, projectId), HttpStatus.OK);
  }

  @RequestMapping(value = "/list", method = RequestMethod.POST)
  public ResponseEntity<List<SmtRequestDto>> list(@RequestParam("projectId") Long projectId) {
    return new ResponseEntity<>(requestService.list(projectId), HttpStatus.OK);
  }
}