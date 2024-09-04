package org.gdsc.uet.dto.response.member;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MemberBasicResponse {
    String fullName;
    String positionName;
    String teamName;
    String generation;
    String university;
}
