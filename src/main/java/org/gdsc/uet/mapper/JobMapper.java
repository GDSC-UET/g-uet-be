package org.gdsc.uet.mapper;
import org.gdsc.uet.dto.request.JobRequest;
import org.gdsc.uet.dto.response.JobResponse;
import org.gdsc.uet.entity.Job;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
@Mapper(componentModel = "spring")
public interface JobMapper {
    Job toJob(JobRequest request);
    JobResponse toJobResponse(Job entity);
}
