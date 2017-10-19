package com.smt.service;

import com.smt.dto.SmtRequestHistoryDto;
import java.util.List;

public interface SmtRequestHistoryService {

  SmtRequestHistoryDto create(SmtRequestHistoryDto requestHistoryDto);

  List<SmtRequestHistoryDto> list(Long requestId);
}