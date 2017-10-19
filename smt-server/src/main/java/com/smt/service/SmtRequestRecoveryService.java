package com.smt.service;

import com.smt.dto.SmtRequestRecoveryDto;
import java.util.List;

public interface SmtRequestRecoveryService {

  SmtRequestRecoveryDto create(SmtRequestRecoveryDto requestRecoveryDto, Long requestId);

  List<SmtRequestRecoveryDto> list(Long requestId);
}