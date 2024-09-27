package org.gdsc.uet.dto.response.applicant;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.gdsc.uet.entity.Member;
import org.gdsc.uet.entity.Position;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApplicantDetailResponse {
    String id;
    String full_name;
    String phone_number;
    String email;
    String position_id;
    Date appliedAt;
    String university;
    String link_CV;
    String notes;
}
