package org.gdsc.uet.controller;

import lombok.RequiredArgsConstructor;
import org.gdsc.uet.dto.request.ProjectCreationRequest;
import org.gdsc.uet.dto.response.project.ProjectBasicResponse;
import org.gdsc.uet.dto.response.project.ProjectDetailResponse;
import org.gdsc.uet.service.IProjectService;
import org.gdsc.uet.ultis.BaseResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/projects")
public class ProjectController {

    private final IProjectService projectService;

    @PostMapping("/create")
    public BaseResponse<ProjectBasicResponse> createNewProject(@RequestBody ProjectCreationRequest request) {
        ProjectBasicResponse response = projectService.createNewProject(request);
        return BaseResponse.<ProjectBasicResponse>builder()
                .message("Project created successfully")
                .result(response)
                .build();
    }

    @PutMapping("/update/{projectId}")
    public BaseResponse<ProjectBasicResponse> updateProject(@PathVariable String projectId, @RequestBody ProjectCreationRequest request) {
        ProjectBasicResponse response = projectService.updateProject(projectId, request);
        return BaseResponse.<ProjectBasicResponse>builder()
                .message("Project updated successfully")
                .result(response)
                .build();
    }

    @DeleteMapping("/delete/{projectId}")
    public BaseResponse<String> deleteProject(@PathVariable String projectId) {
        projectService.deleteProject(projectId);
        return BaseResponse.<String>builder()
                .message("Deleted project successfully")
                .build();
    }

    @GetMapping("/{projectId}")
    public BaseResponse<ProjectDetailResponse> getProjectInfo(@PathVariable String projectId) {
        ProjectDetailResponse response = projectService.getProjectInfo(projectId);
        return BaseResponse.<ProjectDetailResponse>builder()
                .message("Project information retrieved successfully")
                .result(response)
                .build();
    }

    @GetMapping("/all")
    public BaseResponse<List<ProjectBasicResponse>> getAllProjects() {
        List<ProjectBasicResponse> responseList = projectService.getAllProjects();
        return BaseResponse.<List<ProjectBasicResponse>>builder()
                .message("All projects retrieved successfully")
                .result(responseList)
                .build();
    }
}
