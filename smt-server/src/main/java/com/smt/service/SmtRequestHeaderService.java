package com.smt.service;

import com.smt.dto.SmtRequestHeaderDto;
import java.util.List;

public interface SmtRequestHeaderService {

  SmtRequestHeaderDto create(SmtRequestHeaderDto requestHeaderDto, Long requestId);

  List<SmtRequestHeaderDto> list(Long requestId);
}