package com.smt.service;

import com.smt.dto.SmtUserSubscriptionDto;
import java.util.List;

public interface SmtUserSubscriptionService {

  SmtUserSubscriptionDto create(SmtUserSubscriptionDto userSubscriptionDto, Long userId);

  List<SmtUserSubscriptionDto> list(Long userId);
}