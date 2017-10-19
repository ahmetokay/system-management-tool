package com.smt.service;

import com.smt.dto.SmtProjectDto;
import java.util.List;

/**
 * Created by bocal on 8/8/17.
 */
public interface SmtProjectService {

  SmtProjectDto create(SmtProjectDto projectDto);

  List<SmtProjectDto> list(Long projectId);
}