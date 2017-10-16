package com.smt.service;

import com.smt.dto.SmtRequestHeaderDto;
import java.util.List;

public interface SmtRequestHeaderService {

  SmtRequestHeaderDto create(SmtRequestHeaderDto requestHeaderDto);

  List<SmtRequestHeaderDto> list(Long requestId);
}