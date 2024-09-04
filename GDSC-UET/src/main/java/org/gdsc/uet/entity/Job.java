package org.gdsc.uet.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
    String requirements;
}
