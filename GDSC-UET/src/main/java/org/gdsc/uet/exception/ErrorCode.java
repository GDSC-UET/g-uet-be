package org.gdsc.uet.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {
    NOT_FOUNT(404, "Not found", HttpStatus.NOT_FOUND),
    APP_ERROR(1404, "App Error", HttpStatus.BAD_REQUEST);
    private int code;
    private String message;
    private final HttpStatusCode statusCode;

    ErrorCode(int code, String message, HttpStatusCode statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }
}
