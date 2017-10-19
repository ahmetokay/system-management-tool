package com.smt.manager;

import com.smt.entity.SmtProject;
import java.util.List;

/**
 * @author bocal
 */
public interface SmtProjectManager {

  SmtProject create(SmtProject project);

  List<SmtProject> list(Long userId);
}