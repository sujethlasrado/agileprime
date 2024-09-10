package com.lazsoft.agileprime.services;

import com.lazsoft.agileprime.domain.Project;
import com.lazsoft.agileprime.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project){
        return projectRepository.save(project);
    }
}
