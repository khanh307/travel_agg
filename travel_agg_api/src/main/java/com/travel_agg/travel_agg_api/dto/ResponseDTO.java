package com.travel_agg.travel_agg_api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO<T> {
    private int code;
    private String message;
    private T data;

    private static int successCode = 200;
    private static int notFoundCode = 404;
    private static int unauthorizedCode = 401;
    private static int badRequestCode = 400;
    private static int notEnoughInformationCode = 403;

    private static String messageUnauthorized = "Xác thực thất bại";
    private static String messageNotEnoughInformation = "Vui lòng nhập đủ thông tin";

    public static <T> ResponseDTO<T> ok(String message, T data) {
        return new ResponseDTO<>(successCode, message, data);
    }

    public static <T> ResponseDTO<T> notFound(String message) {
        return new ResponseDTO<>(notFoundCode, message, null);
    }

    public static <T> ResponseDTO<T> unauthorized(String message) {
        return new ResponseDTO<>(unauthorizedCode, messageUnauthorized, null);
    }

    public static <T> ResponseDTO<T> notEnoughInformation() {
        return new ResponseDTO<>(notEnoughInformationCode, messageNotEnoughInformation, null);
    }

    public static <T> ResponseDTO<T> badRequest(String message) {
        return new ResponseDTO<>(badRequestCode, message, null);
    }
}
