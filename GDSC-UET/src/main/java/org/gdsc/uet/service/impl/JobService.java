package org.gdsc.uet.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.gdsc.uet.dto.request.JobRequest;
import org.gdsc.uet.dto.response.job.JobBasicResponse;
import org.gdsc.uet.dto.response.job.JobDetailResponse;
import org.gdsc.uet.dto.response.job.JobPageResponse;
import org.gdsc.uet.entity.Job;
import org.gdsc.uet.entity.enums.JobStatus;
import org.gdsc.uet.mapper.JobMapper;
import org.gdsc.uet.repository.JobRepository;
import org.gdsc.uet.service.IJobService;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class JobService implements IJobService {

    private final JobRepository jobRepository;
    private final JobMapper jobMapper;

    @Override
    public JobBasicResponse createNewJob(JobRequest request) {
        Job job = jobMapper.toJob(request);
        Job savedJob = jobRepository.save(job);
        return jobMapper.toJobBasicResponse(savedJob);
    }

    @Override
    public JobBasicResponse updateJob(String jobId, JobRequest request) {
        Job existingJob = jobRepository.findById(jobId)
                .orElseThrow(() -> new IllegalArgumentException("Job not found"));
        jobMapper.toJob(request);
        Job updatedJob = jobRepository.save(existingJob);
        return jobMapper.toJobBasicResponse(updatedJob);
    }

    @Override
    public void deleteJob(String jobId) {
        jobRepository.deleteById(jobId);
    }

    @Override
    public JobDetailResponse getJobInfo(String jobId) {
        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new IllegalArgumentException("Job not found"));
        return jobMapper.toJobDetailResponse(job);
    }

    @Override
    public JobBasicResponse updateJobStatus(String jobId) {
        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found"));

        if (job.getStatus() == JobStatus.CLOSED) {
            job.setStatus(JobStatus.OPEN);
        } else {
            job.setStatus(JobStatus.CLOSED);
        }
        Job updatedJob = jobRepository.save(job);

        // Trả về response sau khi cập nhật
        return jobMapper.toJobBasicResponse(updatedJob);
    }

    @Override
    public JobPageResponse getAllJobs(Pageable pageable) {
        Page<Job> jobPage = jobRepository.findAll(pageable);

        List<JobBasicResponse> jobBasicResponses = jobPage.getContent().stream()
                .map(jobMapper::toJobBasicResponse)
                .collect(Collectors.toList());

        return JobPageResponse.builder()
                .page(jobPage.getNumber())
                .size(jobPage.getSize())
                .totalElements((int) jobPage.getTotalElements())
                .totalPages(jobPage.getTotalPages())
                .jobBasicResponses(jobBasicResponses)
                .build();
    }


}
