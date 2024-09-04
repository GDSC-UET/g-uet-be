package org.gdsc.uet.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.gdsc.uet.dto.request.AwardCreationRequest;
import org.gdsc.uet.service.impl.AwardService;
import org.gdsc.uet.ultis.BaseResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/awards")
public class AwardController {
    AwardService awardService;

    @PostMapping("/createAward")
    BaseResponse<String> createNewAward(@RequestBody AwardCreationRequest request) {
        awardService.createAward(request);
        return BaseResponse.<String>builder()
                .message("Create award successfully")
                .build();
    }

    @DeleteMapping("/{awardName}")
    BaseResponse<String> createNewAward(@PathVariable String awardName) {
        awardService.deleteAward(awardName);
        return BaseResponse.<String>builder()
                .message("Delete award successfully")
                .build();
    }
}
