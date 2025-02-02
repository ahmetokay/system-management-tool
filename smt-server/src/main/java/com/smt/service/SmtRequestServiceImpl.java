package com.smt.service;

import com.smt.converter.SmtRequestConverter;
import com.smt.dto.SmtRequestDto;
import com.smt.entity.SmtProject;
import com.smt.entity.SmtRequest;
import com.smt.manager.SmtRequestManager;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SmtRequestServiceImpl implements SmtRequestService {

  private SmtRequestConverter requestConverter;

  private SmtRequestManager requestManager;

  @Autowired
  public SmtRequestServiceImpl(SmtRequestConverter requestConverter,
      SmtRequestManager requestManager) {
    this.requestConverter = requestConverter;
    this.requestManager = requestManager;
  }

  @Override
  public SmtRequestDto create(SmtRequestDto request, Long projectId) {
    SmtRequest smtRequest = requestConverter.convertToEntity(request);

    SmtProject smtProject = new SmtProject();
    smtProject.setPkid(projectId);
    smtRequest.setSmtProject(smtProject);

    smtRequest = requestManager.create(smtRequest);
    return requestConverter.convertToDto(smtRequest);
  }

  @Override
  public List<SmtRequestDto> list(Long projectId) {
    List<SmtRequest> requestList = requestManager.list(projectId);
    return requestConverter.convertToDtoList(requestList);
  }
}