package org.gdsc.uet.dto.response.job;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JobPageResponse {
    Integer page;
    Integer size;
    Integer totalElements;
    Integer totalPages;

    List<JobBasicResponse> jobBasicResponses;
}
