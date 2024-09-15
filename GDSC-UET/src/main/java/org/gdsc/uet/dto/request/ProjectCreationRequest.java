package org.gdsc.uet.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.gdsc.uet.entity.Member;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProjectCreationRequest {
    String name;
    String status;
    Date startedAt;
    Date finishedAt;
    double version;
    String description;
    Map<String, String> links;
    List<Member> contributors;
}
