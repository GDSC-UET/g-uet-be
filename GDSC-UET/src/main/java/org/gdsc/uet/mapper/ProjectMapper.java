package org.gdsc.uet.mapper;

import org.gdsc.uet.dto.request.ProjectCreationRequest;
import org.gdsc.uet.dto.response.project.ProjectBasicResponse;
import org.gdsc.uet.dto.response.project.ProjectDetailResponse;
import org.gdsc.uet.entity.Project;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    Project toProject(ProjectCreationRequest request);
    ProjectBasicResponse toProjectBasicResponse(Project project);
    ProjectDetailResponse toProjectDetailResponse(Project project);
}
