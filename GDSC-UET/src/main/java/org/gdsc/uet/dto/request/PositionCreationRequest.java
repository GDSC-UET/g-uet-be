package org.gdsc.uet.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PositionCreationRequest {
    String name;
    String responsibilities;
    String teamName;
}
