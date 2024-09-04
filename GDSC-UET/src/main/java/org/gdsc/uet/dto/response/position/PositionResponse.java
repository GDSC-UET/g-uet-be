package org.gdsc.uet.dto.response.position;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PositionResponse {
    String name;
    String responsibilities;
    String teamName;
    Integer memberNum;
}
