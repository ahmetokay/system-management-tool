package com.smt.service;

import com.smt.dto.SmtRequestDto;
import java.util.List;

public interface SmtRequestService {

  SmtRequestDto create(SmtRequestDto requestDto);

  List<SmtRequestDto> list(Long projectId);
}