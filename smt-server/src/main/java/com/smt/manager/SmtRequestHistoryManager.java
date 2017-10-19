package com.smt.manager;

import com.smt.entity.SmtRequestHistory;
import java.util.List;

public interface SmtRequestHistoryManager {

  SmtRequestHistory create(SmtRequestHistory requestHistory);

  List<SmtRequestHistory> list(Long requestId);
}
