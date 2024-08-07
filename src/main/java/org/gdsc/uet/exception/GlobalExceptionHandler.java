package org.gdsc.uet.exception;

import org.gdsc.uet.ultis.BaseResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public BaseResponse<String> handleAppException(Exception ex) {

        return BaseResponse.<String>builder()
                .code(ErrorCode.APP_ERROR.getCode())
                .message(ErrorCode.APP_ERROR.getMessage())
                .result(ex.getMessage())
                .build();
    }
}
