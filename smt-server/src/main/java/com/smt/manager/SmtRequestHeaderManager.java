package com.smt.manager;

import com.smt.entity.SmtRequestHeader;
import java.util.List;

public interface SmtRequestHeaderManager {

  SmtRequestHeader create(SmtRequestHeader requestHeader);

  List<SmtRequestHeader> list(Long requestId);
}