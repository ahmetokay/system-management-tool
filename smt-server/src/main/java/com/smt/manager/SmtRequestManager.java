package com.smt.manager;

import com.smt.entity.SmtRequest;
import java.util.List;

public interface SmtRequestManager {

  SmtRequest create(SmtRequest request);

  List<SmtRequest> list(Long projectId);
}