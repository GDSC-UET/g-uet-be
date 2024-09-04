package org.gdsc.uet.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.gdsc.uet.dto.request.PositionCreationRequest;
import org.gdsc.uet.dto.request.TeamCreationRequest;
import org.gdsc.uet.dto.response.member.MemberBasicResponse;
import org.gdsc.uet.dto.response.position.PositionPageResponse;
import org.gdsc.uet.dto.response.position.PositionResponse;
import org.gdsc.uet.dto.response.team.TeamPageResponse;
import org.gdsc.uet.service.IMemberService;
import org.gdsc.uet.service.IPositionService;
import org.gdsc.uet.service.ITeamService;
import org.gdsc.uet.ultis.BaseResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/teams")
public class TeamController {

    ITeamService teamService;

    IPositionService positionService;

    IMemberService memberService;

    @PostMapping("/createTeam")
    BaseResponse<String> createNewTeam(@RequestBody TeamCreationRequest request) {
        teamService.createTeam(request);
        return BaseResponse.<String>builder()
                .message("Team " + request.getName() + " created successfully")
                .build();
    }

    @PutMapping("/update/{teamName}")
    BaseResponse<PositionResponse> updateTeam(
            @PathVariable String teamName,
            @RequestBody PositionCreationRequest request
    ) {
        PositionResponse response = positionService.updatePosition(teamName, request);
        return BaseResponse.<PositionResponse>builder()
                .message("Updated team successfully")
                .result(response)
                .build();
    }

    @DeleteMapping("/delete/{teamName}")
    BaseResponse<String> deleteTeam(@PathVariable String teamName) {
        teamService.deleteTeam(teamName);
        return BaseResponse.<String>builder()
                .message("Deleted team successfully")
                .build();
    }

    @GetMapping("/all")
    BaseResponse<TeamPageResponse> getAllTeams(
            @RequestParam int page,
            @RequestParam int size
    ) {
        page--;
        return BaseResponse.<TeamPageResponse>builder()
                .message("All teams below")
                .result(teamService.getAllTeams(page, size))
                .build();
    }

    @GetMapping("/{teamName}/positions")
    BaseResponse<PositionPageResponse> getPositionsInTeam(
            @RequestParam Integer page,
            @RequestParam Integer size,
            @PathVariable String teamName) {
        return BaseResponse.<PositionPageResponse>builder()
                .message("These are positions in team" + teamName)
                .result(positionService.getPositionsByTeam(page, size, teamName))
                .build();
    }

    @GetMapping("/{teamName}/members")
    BaseResponse<List<MemberBasicResponse>> getMembersInTeam(@PathVariable String teamName) {
        return null;
    }
}
