package org.gdsc.uet.dto.response.project;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.gdsc.uet.entity.Member;

import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProjectDetailResponse {
    String name;
    double version;
    String description;
    Map<String, String> links;
    List<Member> contributors;
}
