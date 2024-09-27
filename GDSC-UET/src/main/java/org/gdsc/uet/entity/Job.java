package org.gdsc.uet.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.gdsc.uet.entity.enums.JobStatus;
import org.gdsc.uet.entity.enums.JobTag;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
@Document(collection = "jobs")
@Builder
public class Job {
    // add properties
    @Id
    String id;
    String position_name;
    String team_name;
    String description;
    JobStatus status;
    String requirements;
    List<String> list_applicant_id;
    JobTag tag;
}
