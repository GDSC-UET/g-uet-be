package org.gdsc.uet.mapper;

import org.gdsc.uet.dto.request.AwardCreationRequest;
import org.gdsc.uet.dto.response.AwardResponse;
import org.gdsc.uet.entity.Award;
import org.gdsc.uet.entity.Member;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AwardMapper {

    Award toAward(AwardCreationRequest request);

    AwardResponse toAwardResponse(Award award);

    List<AwardResponse> toAwardResponseList(List<Award> awardList);
}
