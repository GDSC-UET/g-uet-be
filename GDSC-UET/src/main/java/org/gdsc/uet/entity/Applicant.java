package org.gdsc.uet.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = "applicant")
public class Applicant {

    @Id
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
