package org.gdsc.uet.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.gdsc.uet.dto.request.MemberCreationRequest;
import org.gdsc.uet.dto.response.member.MemberBasicResponse;
import org.gdsc.uet.dto.response.member.MemberDetailResponse;
import org.gdsc.uet.entity.Member;
import org.gdsc.uet.exception.AppException;
import org.gdsc.uet.exception.ErrorCode;
import org.gdsc.uet.mapper.MemberMapper;
import org.gdsc.uet.repository.MemberRepository;
import org.gdsc.uet.service.IMemberService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MemberService implements IMemberService {

    MemberRepository memberRepository;

    MemberMapper memberMapper;

    @Override
    public MemberBasicResponse createNewMember(MemberCreationRequest request) {
        Member member = memberMapper.toMember(request);
        memberRepository.save(member);

        return MemberBasicResponse.builder()
                .fullName(request.getFullName())
                .positionName(request.getPositionName())
                .teamName(request.getTeamName())
                .generation(request.getGeneration())
                .university(request.getUniversity())
                .build();
    }

    @Override
    public MemberBasicResponse updateMember(String memberId, MemberCreationRequest request) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND));

        if (request.getFullName() != null) member.setFullName(request.getFullName());
        if (request.getUniversity() != null) member.setUniversity(request.getUniversity());
        if (request.getGeneration() != null) member.setGeneration(request.getGeneration());
        if (request.getPositionName() != null) member.setPositionName(request.getPositionName());
        if (request.getTeamName() != null) member.setTeamName(request.getTeamName());
        if (request.getAwardList() != null) member.setAwardList(request.getAwardList());
        if (request.getJoiningDate() != null) member.setJoiningDate(request.getJoiningDate());
        if (request.getLeavingDate() != null) member.setLeavingDate(request.getLeavingDate());
        if (request.getDescription() != null) member.setDescription(request.getDescription());
        if (request.getActivities() != null) member.setActivities(request.getActivities());
        if (request.getFavouriteQuote() != null) member.setFavouriteQuote(request.getFavouriteQuote());
        if (request.getLinkAvatar() != null) member.setLink_avatar(request.getLinkAvatar());
        if (request.getLinkFb() != null) member.setLink_fb(request.getLinkFb());
        if (request.getLinkGithub() != null) member.setLink_github(request.getLinkGithub());
        if (request.getLinkLinkedin() != null) member.setLink_linkedin(request.getLinkLinkedin());


        return null;
    }


    @Override
    public void deleteMember(String memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND));
        memberRepository.delete(member);
    }

    @Override
    public MemberDetailResponse getMemberInfo(String memberId) {
        return null;
    }

    @Override
    public List<MemberBasicResponse> getAllMembers() {
        return List.of();
    }

    @Override
    public List<MemberBasicResponse> getMembersByFilters(String team, String gen) {
        return List.of();
    }
}
