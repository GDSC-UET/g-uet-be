package org.gdsc.uet.dto.response.project;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProjectBasicResponse {
    String id;
    String name;
    String status;
    Date startedAt;
    Date finishedAt;
    double version;
    String description;
}
