package com.smt.controller;

import com.smt.dto.SmtRequestHeaderDto;
import com.smt.service.SmtRequestHeaderService;
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
@RequestMapping(value = "/smt_request_header")
public class SmtRequestHeaderRestService {

  private SmtRequestHeaderService requestHeaderService;

  @Autowired
  public SmtRequestHeaderRestService(SmtRequestHeaderService requestHeaderService) {
    this.requestHeaderService = requestHeaderService;
  }

  @RequestMapping(value = "/create", method = RequestMethod.POST)
  public ResponseEntity<SmtRequestHeaderDto> create(
      @RequestBody SmtRequestHeaderDto requestHeaderDto,
      @RequestParam("requestId") Long requestId) {
    return new ResponseEntity<>(requestHeaderService.create(requestHeaderDto, requestId),
        HttpStatus.OK);
  }

  //FIXME Bilal ile gorusulecek requestBody icerisinden mi alinacak ekstra parametre gibi mi gelecek yoksa body icerisine mi gomulecek?
  @RequestMapping(value = "/list", method = RequestMethod.POST)
  public ResponseEntity<List<SmtRequestHeaderDto>> list(@RequestParam("requestId") Long requestId) {
    return new ResponseEntity<>(requestHeaderService.list(requestId), HttpStatus.OK);
  }
}