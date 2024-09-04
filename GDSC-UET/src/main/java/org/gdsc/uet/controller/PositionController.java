package org.gdsc.uet.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.gdsc.uet.dto.request.PositionCreationRequest;
import org.gdsc.uet.dto.response.position.PositionPageResponse;
import org.gdsc.uet.dto.response.position.PositionResponse;
import org.gdsc.uet.service.IPositionService;
import org.gdsc.uet.ultis.BaseResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/positions")
public class PositionController {

    IPositionService positionService;

    @PostMapping("/create")
    BaseResponse<PositionResponse> createNewPosition(@RequestBody PositionCreationRequest request) {
        PositionResponse response = positionService.createNewPosition(request);
        return BaseResponse.<PositionResponse>builder()
                .message("Position " + request.getName() + " created successfully")
                .result(response)
                .build();
    }

    @PutMapping("/update/{positionName}")
    BaseResponse<PositionResponse> updatePosition(
            @PathVariable String positionName,
            @RequestBody PositionCreationRequest request
    ) {
        PositionResponse response = positionService.updatePosition(positionName, request);
        return BaseResponse.<PositionResponse>builder()
                .message("Updated position successfully")
                .result(response)
                .build();
    }

    @GetMapping("/all")
    BaseResponse<PositionPageResponse> getAllPositions(
            @RequestParam Integer page,
            @RequestParam Integer size
    ) {
        PositionPageResponse responseList = positionService.getAllPositions(page, size);
        return BaseResponse.<PositionPageResponse>builder()
                .message("These are all positions")
                .result(responseList)
                .build();
    }

    @PutMapping

    @DeleteMapping("/delete/{positionName}")
    BaseResponse<String> deletePosition(@PathVariable String positionName) {
        positionService.deletePosition(positionName);
        return BaseResponse.<String>builder()
                .message("Deleted position successfully")
                .build();
    }


}
