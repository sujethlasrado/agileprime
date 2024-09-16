package com.lazsoft.agileprime.services;

import com.lazsoft.agileprime.domain.Project;
import com.lazsoft.agileprime.exceptions.ProjectIdException;
import com.lazsoft.agileprime.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project) {
        try {
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        } catch (Exception e) {
            throw new ProjectIdException("Project ID " + project.getProjectIdentifier().toUpperCase() + " already exists...");
        }
    }

    public Project findProjectByIdentifier(String projectId) {
        Project project = projectRepository.findByProjectIdentifier(projectId);
        if (project != null) {
            return projectRepository.findByProjectIdentifier(projectId.toUpperCase());
        } else {
            throw new ProjectIdException("Project ID" + projectId.toUpperCase() + " does not exists...");
        }

    }

    public Iterable<Project> findAllProjects() {
        return projectRepository.findAll();
    }

    public void deleteProjectByIdentifier(String projectId) {
        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
        if (project == null) {
            throw new ProjectIdException("Project ID" + projectId.toUpperCase() + " was not found...");
        }
        projectRepository.delete(project);

    }
    
}
