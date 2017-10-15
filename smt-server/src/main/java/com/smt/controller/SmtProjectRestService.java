package com.smt.controller;

import com.smt.dto.SmtProjectDto;
import com.smt.service.SmtProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bocal
 */

@RestController
@RequestMapping(value = "/smt_project")
public class SmtProjectRestService {

  private SmtProjectService projectService;

  @Autowired
  public SmtProjectRestService(SmtProjectService projectService) {
    this.projectService = projectService;
  }

  @RequestMapping(value = "/create", method = RequestMethod.POST)
  public ResponseEntity<SmtProjectDto> create(@RequestBody SmtProjectDto projectDto) {
    return new ResponseEntity<SmtProjectDto>(projectService.create(projectDto), HttpStatus.OK);
  }

}
