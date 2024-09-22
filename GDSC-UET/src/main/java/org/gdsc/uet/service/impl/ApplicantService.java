package org.gdsc.uet.service.impl;

import lombok.RequiredArgsConstructor;
import org.gdsc.uet.dto.request.ApplicantCreationRequest;
import org.gdsc.uet.dto.response.applicant.ApplicantBasicResponse;
import org.gdsc.uet.dto.response.applicant.ApplicantDetailResponse;
import org.gdsc.uet.dto.response.applicant.ApplicantPageResponse;
import org.gdsc.uet.entity.Applicant;
import org.gdsc.uet.mapper.ApplicantMapper;
import org.gdsc.uet.repository.ApplicantRepository;
import org.gdsc.uet.service.IApplicantService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApplicantService implements IApplicantService {

    private final ApplicantRepository applicantRepository;
    private final ApplicantMapper applicantMapper;

    @Override
    public ApplicantBasicResponse createNewApplicant(ApplicantCreationRequest request) {
        Applicant applicant = applicantMapper.toApplicant(request);
        Applicant savedApplicant = applicantRepository.save(applicant);
        return applicantMapper.toApplicantBasicResponse(savedApplicant);
    }

    @Override
    public ApplicantBasicResponse updateApplicant(String applicantId, ApplicantCreationRequest request) {
        Applicant existingApplicant = applicantRepository.findById(applicantId)
                .orElseThrow(() -> new IllegalArgumentException("Applicant not found"));
        applicantMapper.toApplicant(request);
        Applicant updatedApplicant = applicantRepository.save(existingApplicant);
        return applicantMapper.toApplicantBasicResponse(updatedApplicant);
    }

    @Override
    public ApplicantDetailResponse getApplicantInfo(String applicantId) {
        Applicant applicant = applicantRepository.findById(applicantId)
                .orElseThrow(() -> new IllegalArgumentException("Applicant not found"));
        return applicantMapper.toApplicantDetailResponse(applicant);
    }

    @Override
    public ApplicantPageResponse getAllApplicants(Pageable pageable) {
        Page<Applicant> applicantPage = applicantRepository.findAll(pageable);

        List<ApplicantBasicResponse> applicantBasicResponses = applicantPage.getContent().stream()
                .map(applicantMapper::toApplicantBasicResponse)
                .collect(Collectors.toList());

        return ApplicantPageResponse.builder()
                .page(applicantPage.getNumber())
                .size(applicantPage.getSize())
                .totalElements((int) applicantPage.getTotalElements())
                .totalPages(applicantPage.getTotalPages())
                .applicantBasicResponses(applicantBasicResponses)
                .build();
    }
}
