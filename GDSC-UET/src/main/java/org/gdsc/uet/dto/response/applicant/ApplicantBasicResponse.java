package org.gdsc.uet.dto.response.applicant;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.gdsc.uet.entity.Position;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApplicantBasicResponse {
    String id;
    String full_name;
    Position position;
    String link_CV;
    Date appliedAt;
}
