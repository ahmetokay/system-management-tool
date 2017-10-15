package com.smt.service;

import com.smt.converter.SmtProjectConverter;
import com.smt.dto.SmtProjectDto;
import com.smt.entity.SmtProject;
import com.smt.manager.SmtProjectManager;
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
    public SmtProjectDto create(SmtProjectDto project) {
        SmtProject smtProject = projectManager.create(projectConverter.convertToEntity(project));
        return projectConverter.convertToDto(smtProject);
    }
}