package com.knox.askgpt.exception;

import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponse {
    public static final String ERROR_ID_KEY = "errorId";
    public static final String ERROR_AT_KEY = "errorAt";
    private String errorId;
    private LocalDateTime errorAt;
    private String errorLocation;
    private ErrorMessage error;
    private List<ErrorMessage> errors;
    private Boolean populateErrors;
    public static DateTimeFormatter ft = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "errorId='" + errorId + '\'' +
                ", errorAt=" + errorAt +
                ", errorLocation='" + errorLocation + '\'' +
                ", error=" + error +
                ", errors=" + errors +
                ", populateErrors=" + populateErrors +
                '}';
    }

}