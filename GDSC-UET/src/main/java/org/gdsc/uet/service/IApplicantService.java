package org.gdsc.uet.service;

import org.gdsc.uet.dto.request.ApplicantCreationRequest;
import org.gdsc.uet.dto.response.applicant.ApplicantBasicResponse;
import org.gdsc.uet.dto.response.applicant.ApplicantDetailResponse;
import org.gdsc.uet.dto.response.applicant.ApplicantPageResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IApplicantService {

    ApplicantBasicResponse createNewApplicant(ApplicantCreationRequest request);

    ApplicantBasicResponse updateApplicant(String applicantId, ApplicantCreationRequest request);

    ApplicantDetailResponse getApplicantInfo(String applicantId);

    ApplicantPageResponse getAllApplicants(Pageable pageable);
}
