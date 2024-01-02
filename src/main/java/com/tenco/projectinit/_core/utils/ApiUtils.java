package com.tenco.projectinit._core.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

public class ApiUtils {

    public static <T> ApiResult<T> success(T response) {

        return new ApiResult<>(true, response, null);
    }

    public static ApiResult<?> error(String message, HttpStatus status) {

        return new ApiResult<>(false, null, new ApiError(message, status.value()));
    }

    @Data
    @AllArgsConstructor
    public static class ApiResult<T> {
        private final boolean success;
        private final T response;
        private final ApiError error;
    }

    @Data
    @AllArgsConstructor
    public static class ApiError {
        private final String message;
        private final int status;
    }
}