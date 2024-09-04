package org.gdsc.uet.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.gdsc.uet.dto.request.AwardCreationRequest;
import org.gdsc.uet.entity.Award;
import org.gdsc.uet.mapper.AwardMapper;
import org.gdsc.uet.repository.AwardRepository;
import org.gdsc.uet.service.IAwardService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AwardService implements IAwardService {
    AwardMapper awardMapper;
    AwardRepository awardRepository;

    @Override
    public void createAward(AwardCreationRequest request) {
        Award newAward = awardMapper.toAward(request);
        awardRepository.save(newAward);
    }

    @Override
    public void deleteAward(String name) {
        Award award = awardRepository.findByName(name);
        awardRepository.delete(award);
    }


}
