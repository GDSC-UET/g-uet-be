package org.gdsc.uet.dto.response.applicant;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApplicantPageResponse {
    Integer page;
    Integer size;
    Integer totalElements;
    Integer totalPages;

    List<ApplicantBasicResponse> applicantBasicResponses;
}
