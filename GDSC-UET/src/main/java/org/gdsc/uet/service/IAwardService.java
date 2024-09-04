package org.gdsc.uet.service;

import org.gdsc.uet.dto.request.AwardCreationRequest;
import org.gdsc.uet.dto.response.AwardResponse;
import org.springframework.stereotype.Service;

@Service
public interface IAwardService {
    void createAward(AwardCreationRequest request);
    void deleteAward(String name);
}
