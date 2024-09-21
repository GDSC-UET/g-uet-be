package org.gdsc.uet.service;

import org.gdsc.uet.dto.request.JobRequest;
import org.gdsc.uet.dto.response.job.JobBasicResponse;
import org.gdsc.uet.dto.response.job.JobDetailResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IJobService {

    JobBasicResponse createNewJob(JobRequest request);

    JobBasicResponse updateJob(String jobId, JobRequest request);

    void deleteJob(String jobId);

    JobDetailResponse getJobInfo(String jobId);

    List<JobBasicResponse> getAllJobs();
}
