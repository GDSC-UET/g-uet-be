package org.gdsc.uet.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.gdsc.uet.dto.request.TeamCreationRequest;
import org.gdsc.uet.dto.response.team.TeamPageResponse;
import org.gdsc.uet.dto.response.team.TeamResponse;
import org.gdsc.uet.entity.Team;
import org.gdsc.uet.mapper.TeamMapper;
import org.gdsc.uet.repository.MemberRepository;
import org.gdsc.uet.repository.PositionRepository;
import org.gdsc.uet.repository.TeamRepository;
import org.gdsc.uet.service.ITeamService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TeamService implements ITeamService {

    TeamRepository teamRepository;

    PositionRepository positionRepository;

    MemberRepository memberRepository;

    TeamMapper teamMapper;

    @Override
    public void createTeam(TeamCreationRequest request) {
        Team newTeam = teamMapper.toTeam(request);
        newTeam.setId(UUID.randomUUID().toString());
        teamRepository.save(newTeam);
    }

    @Override
    public TeamPageResponse getAllTeams(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Team> teams = teamRepository.findAll(pageable);

        List<TeamResponse> teamResponses = teams.map(team -> new TeamResponse(
                team.getName(),
                team.getDescription(),
                positionRepository.countByTeamName(team.getName())
        )).getContent();

        return TeamPageResponse.builder()
                .page(page)
                .size(size)
                .totalElements(teams.getTotalElements())
                .totalPages(teams.getTotalPages())
                .teams(teamResponses)
                .build();
    }

    @Override
    public TeamResponse updateTeam(String teamName, TeamCreationRequest request) {
        Team team = teamRepository.findByName(teamName);

        if (request.getName() != null)  team.setName(request.getName());
        if (request.getDescription() != null) team.setDescription(request.getDescription());

        return teamMapper.toTeamResponse(teamRepository.save(team));
    }

    @Override
    public void deleteTeam(String teamName) {
        teamRepository.deleteTeamsByName(teamName);
        positionRepository.deleteByTeamName(teamName);
    }


}
