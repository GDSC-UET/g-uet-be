package org.gdsc.uet.service;

import org.gdsc.uet.dto.request.ApplicantCreationRequest;
import org.gdsc.uet.dto.response.applicant.ApplicantBasicResponse;
import org.gdsc.uet.dto.response.applicant.ApplicantDetailResponse;

import java.util.List;

public interface IApplicantService {

    ApplicantBasicResponse createNewApplicant(ApplicantCreationRequest request);

    ApplicantBasicResponse updateApplicant(String applicantId, ApplicantCreationRequest request);

    ApplicantDetailResponse getApplicantInfo(String applicantId);

    List<ApplicantBasicResponse> getAllApplicants();
}
