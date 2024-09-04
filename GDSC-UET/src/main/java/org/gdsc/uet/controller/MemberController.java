package org.gdsc.uet.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.gdsc.uet.dto.request.MemberCreationRequest;
import org.gdsc.uet.dto.response.member.MemberBasicResponse;
import org.gdsc.uet.dto.response.member.MemberDetailResponse;
import org.gdsc.uet.service.IMemberService;
import org.gdsc.uet.ultis.BaseResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/members")
public class MemberController {
    IMemberService memberService;

    @PostMapping("/create")
    public BaseResponse<MemberBasicResponse> createNewMember(MemberCreationRequest request) {

        return null;
    }

    @DeleteMapping("/delete/{member_id}")
    public BaseResponse<String> deleteMember(@PathVariable String member_id) {
        // memberService.deleteMember(member_id);
        return BaseResponse.<String>builder()
                .message("Deleted member successfully")
                .build();
    }

    @GetMapping("/{member_id}")
    public BaseResponse<MemberDetailResponse> getMemberInfo(@PathVariable String member_id) {
        MemberDetailResponse detailResponse = memberService.getMemberInfo(member_id);
        return BaseResponse.<MemberDetailResponse>builder()
                .message("This is member information")
                .result(detailResponse)
                .build();
    }

    @GetMapping("/all")
    public BaseResponse<List<MemberBasicResponse>> getAllMembers() {
        List<MemberBasicResponse> basicResponseList = memberService.getAllMembers();
        return BaseResponse.<List<MemberBasicResponse>>builder()
                .message("These are all members")
                .result(basicResponseList)
                .build();
    }

    @GetMapping("/allBy")
    public BaseResponse<List<MemberBasicResponse>> getMembersByFilters(
            @RequestParam String team,
            @RequestParam String gen) {
        List<MemberBasicResponse> basicResponseList = memberService.getMembersByFilters(team, gen);
        return BaseResponse.<List<MemberBasicResponse>>builder()
                .message("These are suitable members")
                .result(basicResponseList)
                .build();
    }
}
