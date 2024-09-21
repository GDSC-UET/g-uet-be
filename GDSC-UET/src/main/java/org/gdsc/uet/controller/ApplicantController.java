package org.gdsc.uet.controller;

import lombok.RequiredArgsConstructor;
import org.gdsc.uet.dto.request.ApplicantCreationRequest;
import org.gdsc.uet.dto.response.applicant.ApplicantBasicResponse;
import org.gdsc.uet.dto.response.applicant.ApplicantBasicResponse;
import org.gdsc.uet.dto.response.applicant.ApplicantDetailResponse;
import org.gdsc.uet.dto.response.applicant.ApplicantPageResponse;
import org.gdsc.uet.service.IApplicantService;
import org.gdsc.uet.ultis.BaseResponse;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/applicants")
public class ApplicantController {
    private final IApplicantService applicantService;

    @PostMapping("/create")
    public BaseResponse<ApplicantBasicResponse> createNewApplicant(@RequestBody ApplicantCreationRequest request) {
        ApplicantBasicResponse response = applicantService.createNewApplicant(request);
        return BaseResponse.<ApplicantBasicResponse>builder()
                .message("Applicant created successfully")
                .result(response)
                .build();
    }

    @PutMapping("/update/{applicantId}")
    public BaseResponse<ApplicantBasicResponse> updateApplicant(@PathVariable String applicantId, @RequestBody ApplicantCreationRequest request) {
        ApplicantBasicResponse response = applicantService.updateApplicant(applicantId, request);
        return BaseResponse.<ApplicantBasicResponse>builder()
                .message("Applicant updated successfully")
                .result(response)
                .build();
    }
    @GetMapping("/{applicantId}")
    public BaseResponse<ApplicantDetailResponse> getApplicantInfo(@PathVariable String applicantId) {
        ApplicantDetailResponse response = applicantService.getApplicantInfo(applicantId);
        return BaseResponse.<ApplicantDetailResponse>builder()
                .message("Applicant information retrieved successfully")
                .result(response)
                .build();
    }

    @GetMapping("/all")
    public BaseResponse<ApplicantPageResponse> getAllJobs(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        ApplicantPageResponse response = applicantService.getAllApplicants(PageRequest.of(page, size));

        return BaseResponse.<ApplicantPageResponse>builder()
                .message("All jobs retrieved successfully")
                .result(response)
                .build();
    }
}
