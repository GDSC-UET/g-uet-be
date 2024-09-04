package org.gdsc.uet.mapper;

import org.gdsc.uet.dto.request.PositionCreationRequest;
import org.gdsc.uet.dto.response.position.PositionResponse;
import org.gdsc.uet.entity.Position;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PositionMapper {

    Position toPosition(PositionCreationRequest request);

    PositionResponse toPositionResponse(Position position);

    List<PositionResponse> toPositionResponseList(List<Position> positionList);
}
