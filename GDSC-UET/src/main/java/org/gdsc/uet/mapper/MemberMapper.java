package org.gdsc.uet.mapper;

import org.gdsc.uet.dto.request.MemberCreationRequest;
import org.gdsc.uet.dto.response.member.MemberBasicResponse;
import org.gdsc.uet.dto.response.member.MemberDetailResponse;
import org.gdsc.uet.entity.Member;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {

    Member toMember(MemberCreationRequest request);

    MemberBasicResponse toMemberBasicResponse(Member member);

    MemberDetailResponse toMemberDetailResponse(Member member);

}
