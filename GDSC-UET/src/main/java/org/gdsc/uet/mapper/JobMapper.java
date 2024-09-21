package org.gdsc.uet.mapper;
import org.gdsc.uet.dto.request.JobRequest;
import org.gdsc.uet.dto.response.job.JobBasicResponse;
import org.gdsc.uet.dto.response.job.JobDetailResponse;
import org.gdsc.uet.entity.Job;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JobMapper {
    Job toJob(JobRequest request);
    JobBasicResponse toJobBasicResponse(Job entity);
    JobDetailResponse toJobDetailResponse(Job entity);
}
