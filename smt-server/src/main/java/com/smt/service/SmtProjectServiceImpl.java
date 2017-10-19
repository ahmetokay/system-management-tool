package com.smt.service;

import com.smt.converter.SmtProjectConverter;
import com.smt.dto.SmtProjectDto;
import com.smt.entity.SmtProject;
import com.smt.entity.SmtUser;
import com.smt.manager.SmtProjectManager;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by bocal on 8/8/17.
 */
@Component
public class SmtProjectServiceImpl implements SmtProjectService {

  private SmtProjectConverter projectConverter;

  private SmtProjectManager projectManager;

  @Autowired
  public SmtProjectServiceImpl(SmtProjectConverter projectConverter,
      SmtProjectManager projectManager) {
    this.projectConverter = projectConverter;
    this.projectManager = projectManager;
  }

  @Override
  public SmtProjectDto create(SmtProjectDto projectDto, Long userId) {
    SmtProject smtProject = projectConverter.convertToEntity(projectDto);

    SmtUser smtUser = new SmtUser();
    smtUser.setPkid(userId);
    smtProject.setSmtUser(smtUser);

    smtProject = projectManager.create(smtProject);

    return projectConverter.convertToDto(smtProject);
  }

  @Override
  public List<SmtProjectDto> list(Long userId) {
    List<SmtProject> projectList = projectManager.list(userId);
    return projectConverter.convertToDtoList(projectList);
  }
}