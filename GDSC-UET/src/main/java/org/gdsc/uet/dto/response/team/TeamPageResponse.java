package org.gdsc.uet.dto.response.team;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TeamPageResponse {

    Integer page;
    Integer size;
    long totalElements;
    Integer totalPages;

    List<TeamResponse> teams;

}
