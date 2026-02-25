package com.knox.askgpt.exception;

import lombok.*;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class ErrorMessage {
    private String code;
    private String title;
    private String message;
    private String[] values;
    private String origmesg;
    private Map<String, String> errors;
    public static ErrorMessage buildErrorMessage(String code, String message,  String origmesg) {
        return ErrorMessage.builder().code(code).message(message).origmesg(origmesg).build() ;
    }

}
