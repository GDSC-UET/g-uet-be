package org.gdsc.uet.dto.response.team;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TeamResponse {
    String team_name;
    String description;
    int positionNum;
}
