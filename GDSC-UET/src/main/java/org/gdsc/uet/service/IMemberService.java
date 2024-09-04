package org.gdsc.uet.service;

import org.gdsc.uet.dto.request.MemberCreationRequest;
import org.gdsc.uet.dto.response.member.MemberBasicResponse;
import org.gdsc.uet.dto.response.member.MemberDetailResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IMemberService {

    MemberBasicResponse createNewMember(MemberCreationRequest request);

    MemberBasicResponse updateMember(String memberId, MemberCreationRequest request);

    void deleteMember(String memberId);

    MemberDetailResponse getMemberInfo(String memberId);

    List<MemberBasicResponse> getAllMembers();

    List<MemberBasicResponse> getMembersByFilters(String team, String gen);
}
