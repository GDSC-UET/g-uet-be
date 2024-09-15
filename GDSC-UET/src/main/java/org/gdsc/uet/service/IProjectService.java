package org.gdsc.uet.service;

import org.gdsc.uet.dto.request.ProjectCreationRequest;
import org.gdsc.uet.dto.response.project.ProjectBasicResponse;
import org.gdsc.uet.dto.response.project.ProjectDetailResponse;

import java.util.List;

public interface IProjectService {

    ProjectBasicResponse createNewProject(ProjectCreationRequest request);

    ProjectBasicResponse updateProject(String projectId, ProjectCreationRequest request);

    void deleteProject(String projectId);

    ProjectDetailResponse getProjectInfo(String projectId);

    List<ProjectBasicResponse> getAllProjects();
}
