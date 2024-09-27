package org.gdsc.uet.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.gdsc.uet.entity.enums.JobStatus;
import org.gdsc.uet.entity.enums.JobTag;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JobRequest {
    String id;
    String position_name;
    String description;
    JobStatus status;
    JobTag tag;
}
