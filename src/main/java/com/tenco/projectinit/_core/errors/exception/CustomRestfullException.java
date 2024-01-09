package com.tenco.projectinit._core.errors.exception;

import com.google.api.Http;
import com.tenco.projectinit._core.utils.ApiUtils;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class CustomRestfullException extends RuntimeException {
    private HttpStatus status;

    public CustomRestfullException(String message, HttpStatus httpStatus) {
        super(message);
        this.status = httpStatus;
    }

//    public Exception400(String message) {
//        super(message);
//    }
//
//    public ApiUtils.ApiResult<?> body() {
//        return ApiUtils.error(getMessage(), HttpStatus.BAD_REQUEST);
//    }
//
//    public HttpStatus status() {
//        return HttpStatus.BAD_REQUEST;
//    }
}