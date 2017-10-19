package com.smt.manager;

import com.smt.entity.SmtRequestRecovery;
import java.util.List;

public interface SmtRequestRecoveryManager {

  SmtRequestRecovery create(SmtRequestRecovery requestRecovery);

  List<SmtRequestRecovery> list(Long requestId);
}