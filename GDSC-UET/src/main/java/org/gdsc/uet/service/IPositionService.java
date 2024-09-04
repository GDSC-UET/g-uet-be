package org.gdsc.uet.service;

import org.gdsc.uet.dto.request.PositionCreationRequest;
import org.gdsc.uet.dto.response.position.PositionPageResponse;
import org.gdsc.uet.dto.response.position.PositionResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPositionService {

    PositionResponse createNewPosition(PositionCreationRequest request);

    PositionResponse updatePosition(String name, PositionCreationRequest request);

    void deletePosition(String positionName);

    PositionPageResponse getAllPositions(Integer page, Integer size);

    PositionPageResponse getPositionsByTeam(Integer page, Integer size, String teamName);
}
