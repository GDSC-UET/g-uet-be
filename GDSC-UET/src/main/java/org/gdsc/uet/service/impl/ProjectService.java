package org.gdsc.uet.service.impl;

import lombok.RequiredArgsConstructor;
import org.gdsc.uet.dto.request.ProjectCreationRequest;
import org.gdsc.uet.dto.response.project.ProjectBasicResponse;
import org.gdsc.uet.dto.response.project.ProjectDetailResponse;
import org.gdsc.uet.entity.Project;
import org.gdsc.uet.mapper.ProjectMapper;
import org.gdsc.uet.repository.ProjectRepository;
import org.gdsc.uet.service.IProjectService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectService implements IProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    @Override
    public ProjectBasicResponse createNewProject(ProjectCreationRequest request) {
        Project project = projectMapper.toProject(request);
        Project savedProject = projectRepository.save(project);
        return projectMapper.toProjectBasicResponse(savedProject);
    }

    @Override
    public ProjectBasicResponse updateProject(String projectId, ProjectCreationRequest request) {
        Project existingProject = projectRepository.findById(projectId)
                .orElseThrow(() -> new IllegalArgumentException("Project not found"));
        projectMapper.toProject(request);
        Project updatedProject = projectRepository.save(existingProject);
        return projectMapper.toProjectBasicResponse(updatedProject);
    }

    @Override
    public void deleteProject(String projectId) {
        projectRepository.deleteById(projectId);
    }

    @Override
    public ProjectDetailResponse getProjectInfo(String projectId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new IllegalArgumentException("Project not found"));
        return projectMapper.toProjectDetailResponse(project);
    }

    @Override
    public List<ProjectBasicResponse> getAllProjects() {
        return projectRepository.findAll().stream()
                .map(projectMapper::toProjectBasicResponse)
                .collect(Collectors.toList());
    }
}
