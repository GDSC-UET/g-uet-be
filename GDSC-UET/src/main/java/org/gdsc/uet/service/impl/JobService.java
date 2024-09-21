package org.gdsc.uet.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.gdsc.uet.dto.request.JobRequest;
import org.gdsc.uet.dto.response.job.JobBasicResponse;
import org.gdsc.uet.dto.response.job.JobDetailResponse;
import org.gdsc.uet.entity.Job;
import org.gdsc.uet.mapper.JobMapper;
import org.gdsc.uet.repository.JobRepository;
import org.gdsc.uet.service.IJobService;
import org.springframework.stereotype.Service;

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
    public List<JobBasicResponse> getAllJobs() {
        return jobRepository.findAll().stream()
                .map(jobMapper::toJobBasicResponse)
                .collect(Collectors.toList());
    }
}
