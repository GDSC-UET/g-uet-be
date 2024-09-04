package org.gdsc.uet.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.gdsc.uet.dto.request.PositionCreationRequest;
import org.gdsc.uet.dto.response.position.PositionPageResponse;
import org.gdsc.uet.dto.response.position.PositionResponse;
import org.gdsc.uet.entity.Position;
import org.gdsc.uet.mapper.PositionMapper;
import org.gdsc.uet.repository.MemberRepository;
import org.gdsc.uet.repository.PositionRepository;
import org.gdsc.uet.service.IPositionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PositionService implements IPositionService {

    PositionRepository positionRepository;

    MemberRepository memberRepository;

    PositionMapper positionMapper;

    @Override
    public PositionResponse createNewPosition(PositionCreationRequest request) {
        Position newPosition = positionMapper.toPosition(request);
        newPosition.setId(UUID.randomUUID().toString());
        positionRepository.save(newPosition);
        return positionMapper.toPositionResponse(newPosition);
    }

    @Override
    public PositionResponse updatePosition(String name, PositionCreationRequest request) {
        Position position = positionRepository.findByName(name);

        if (request.getName() != null) position.setName(request.getName());
        if (request.getResponsibilities() != null) position.setResponsibilities(request.getResponsibilities());
        if (request.getTeamName() != null) position.setTeamName(request.getTeamName());

        return positionMapper.toPositionResponse(positionRepository.save(position));
    }

    @Override
    public void deletePosition(String positionName) {
        Position position = positionRepository.findByName(positionName);
        positionRepository.delete(position);
    }

    @Override
    public PositionPageResponse getAllPositions(Integer page, Integer size) {
        page--;

        Pageable pageable = PageRequest.of(page, size);
        Page<Position> positionList = positionRepository.findAll(pageable);

        List<PositionResponse> positionResponses = positionList.map(position -> new PositionResponse(
                position.getName(),
                position.getResponsibilities(),
                position.getTeamName(),
                memberRepository.countByPositionName(position.getName())
        )).getContent();

        return PositionPageResponse.builder()
                .page(page)
                .size(size)
                .totalElements(positionList.getTotalElements())
                .totalPages(positionList.getTotalPages())
                .positionResponses(positionResponses)
                .build();
    }

    @Override
    public PositionPageResponse getPositionsByTeam(Integer page, Integer size, String teamName) {
        page--;

        Pageable pageable = PageRequest.of(page, size);
        Page<Position> positionList = positionRepository.findByTeamName(teamName, pageable);

        List<PositionResponse> positionResponses = positionList.map(position -> new PositionResponse(
                position.getName(),
                position.getResponsibilities(),
                position.getTeamName(),
                memberRepository.countByPositionName(position.getName())
        )).getContent();

        return PositionPageResponse.builder()
                .page(page)
                .size(size)
                .totalElements(positionList.getTotalElements())
                .totalPages(positionList.getTotalPages())
                .positionResponses(positionResponses)
                .build();
    }
}
