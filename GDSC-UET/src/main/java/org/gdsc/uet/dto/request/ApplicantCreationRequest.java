package org.gdsc.uet.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.gdsc.uet.entity.Position;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApplicantCreationRequest {
    String full_name;
    String phone_number;
    String email;
    Position position;
    Date appliedAt;
    String university;
    String link_CV;
    String notes;
}
