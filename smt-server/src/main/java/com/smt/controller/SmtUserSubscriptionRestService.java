package com.smt.controller;

import com.smt.dto.SmtUserSubscriptionDto;
import com.smt.service.SmtUserSubscriptionService;
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
@RequestMapping(value = "/smt_user_subscription")
public class SmtUserSubscriptionRestService {

  private SmtUserSubscriptionService smtUserSubscriptionService;

  @Autowired
  public SmtUserSubscriptionRestService(SmtUserSubscriptionService smtUserSubscriptionService) {
    this.smtUserSubscriptionService = smtUserSubscriptionService;
  }

  @RequestMapping(value = "/create", method = RequestMethod.POST)
  public ResponseEntity<SmtUserSubscriptionDto> create(
      @RequestBody SmtUserSubscriptionDto userSubscriptionDto,
      @RequestParam("userId") Long userId) {
    return new ResponseEntity<>(smtUserSubscriptionService.create(userSubscriptionDto, userId),
        HttpStatus.OK);
  }

  @RequestMapping(value = "/list", method = RequestMethod.POST)
  public ResponseEntity<List<SmtUserSubscriptionDto>> list(@RequestParam("userId") Long userId) {
    return new ResponseEntity<>(smtUserSubscriptionService.list(userId), HttpStatus.OK);
  }
}