package org.gdsc.uet.controller;

import lombok.RequiredArgsConstructor;
import org.gdsc.uet.dto.request.JobRequest;
import org.gdsc.uet.dto.response.job.JobBasicResponse;
import org.gdsc.uet.dto.response.job.JobDetailResponse;
import org.gdsc.uet.service.IJobService;
import org.gdsc.uet.ultis.BaseResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jobs")
public class JobController {

    private final IJobService jobService;

    @PostMapping("/create")
    public BaseResponse<JobBasicResponse> createNewJob(@RequestBody JobRequest request) {
        JobBasicResponse response = jobService.createNewJob(request);
        return BaseResponse.<JobBasicResponse>builder()
                .message("Job created successfully")
                .result(response)
                .build();
    }

    @PutMapping("/update/{jobId}")
    public BaseResponse<JobBasicResponse> updateJob(@PathVariable String jobId, @RequestBody JobRequest request) {
        JobBasicResponse response = jobService.updateJob(jobId, request);
        return BaseResponse.<JobBasicResponse>builder()
                .message("Job updated successfully")
                .result(response)
                .build();
    }

    @DeleteMapping("/delete/{jobId}")
    public BaseResponse<String> deleteJob(@PathVariable String jobId) {
        jobService.deleteJob(jobId);
        return BaseResponse.<String>builder()
                .message("Deleted job successfully")
                .build();
    }

    @GetMapping("/{jobId}")
    public BaseResponse<JobDetailResponse> getJobInfo(@PathVariable String jobId) {
        JobDetailResponse response = jobService.getJobInfo(jobId);
        return BaseResponse.<JobDetailResponse>builder()
                .message("Job information retrieved successfully")
                .result(response)
                .build();
    }

    @GetMapping("/all")
    public BaseResponse<List<JobBasicResponse>> getAllJobs() {
        List<JobBasicResponse> responseList = jobService.getAllJobs();
        return BaseResponse.<List<JobBasicResponse>>builder()
                .message("All jobs retrieved successfully")
                .result(responseList)
                .build();
    }
}
