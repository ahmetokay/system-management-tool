package com.smt.manager;

import com.smt.entity.SmtProject;
import com.smt.repository.SmtProjectRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author bocal
 */
@Component
@Transactional(readOnly = true)
public class SmtProjectManagerImpl implements SmtProjectManager {

  private String SELECT_QUERY = "SELECT t FROM SmtProject t WHERE t.isActive=true and t.smtUser=%s";

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

  @Override
  public List<SmtProject> list(Long userId) {
    return projectRepository.query(String.format(SELECT_QUERY, userId));
  }
}