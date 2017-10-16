package com.smt.manager;

import com.smt.entity.SmtProject;
import com.smt.repository.SmtProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author bocal
 */
@Component
@Transactional(readOnly = true)
public class SmtProjectManagerImpl implements SmtProjectManager {

  private SmtProjectRepository projectRepository;

  @Autowired
  public SmtProjectManagerImpl(SmtProjectRepository projectRepository) {
    this.projectRepository = projectRepository;
  }

  @Override
  @Transactional
  public SmtProject create(SmtProject project) {
    return projectRepository.save(project);
  }
}