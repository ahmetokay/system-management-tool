package com.smt.service;

import com.smt.dto.SmtRequestDto;
import java.util.List;

public interface SmtRequestService {

  SmtRequestDto create(SmtRequestDto requestDto, Long projectId);

  List<SmtRequestDto> list(Long projectId);
}