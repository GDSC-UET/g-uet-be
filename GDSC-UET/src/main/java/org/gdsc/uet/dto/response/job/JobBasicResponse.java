package org.gdsc.uet.dto.response.job;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.gdsc.uet.entity.enums.JobStatus;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JobBasicResponse {
    String id;
    String position_name;
    String team_name;
    String description;
    JobStatus status;
}
