package org.gdsc.uet.dto.response.member;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MemberPageResponse {
    Integer page;
    Integer size;
    Integer totalElements;
    Integer totalPages;

    List<MemberBasicResponse> memberBasicResponses;
}
