package org.gdsc.uet.dto.response.project;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.gdsc.uet.entity.Project;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProjectPageResponse {
    Integer page;
    Integer size;
    Integer totalElements;
    Integer totalPages;

    List<ProjectBasicResponse> projectBasicResponses;
}
