package org.gdsc.uet.dto.response.job;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.gdsc.uet.entity.Applicant;
import org.gdsc.uet.entity.enums.JobStatus;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JobDetailResponse {
    String id;
    String position_name;
    JobStatus status;
    String description;
    List<Applicant> applicants;
}
