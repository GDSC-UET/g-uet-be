package org.gdsc.uet.service;

import org.gdsc.uet.dto.request.TeamCreationRequest;
import org.gdsc.uet.dto.response.team.TeamPageResponse;
import org.gdsc.uet.dto.response.team.TeamResponse;
import org.springframework.stereotype.Service;

@Service
public interface ITeamService {

    void createTeam(TeamCreationRequest request);

    TeamPageResponse getAllTeams(int page, int size);

    TeamResponse updateTeam(String teamName, TeamCreationRequest request);

    void deleteTeam(String teamName);
}
