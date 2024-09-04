package org.gdsc.uet.mapper;

import org.gdsc.uet.dto.request.TeamCreationRequest;
import org.gdsc.uet.dto.response.team.TeamResponse;
import org.gdsc.uet.entity.Team;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeamMapper {

    Team toTeam(TeamCreationRequest request);

    TeamResponse toTeamResponse(Team team);

    List<TeamResponse> toTeamResponseList(List<Team> teamList);
}
