package org.gdsc.uet.mapper;

import org.gdsc.uet.dto.request.ApplicantCreationRequest;
import org.gdsc.uet.dto.response.applicant.ApplicantBasicResponse;
import org.gdsc.uet.dto.response.applicant.ApplicantDetailResponse;
import org.gdsc.uet.entity.Applicant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ApplicantMapper {
    Applicant toApplicant(ApplicantCreationRequest request);
    ApplicantBasicResponse toApplicantBasicResponse(Applicant applicant);
    ApplicantDetailResponse toApplicantDetailResponse(Applicant applicant);

}
