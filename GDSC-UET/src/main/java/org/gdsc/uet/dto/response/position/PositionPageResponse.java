package org.gdsc.uet.dto.response.position;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PositionPageResponse {
    Integer page;
    Integer size;
    long totalElements;
    Integer totalPages;
    List<PositionResponse> positionResponses;
}
