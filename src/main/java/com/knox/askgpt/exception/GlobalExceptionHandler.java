package com.knox.askgpt.exception;

import com.knox.askgpt.config.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private AppConfig appConfig;

    @ResponseBody
    @ExceptionHandler({MaskingPatternException.class})
    public Mono<ResponseEntity<ErrorResponse>> handleMaskingPatternException(MaskingPatternException ex) {
        ErrorMessage errorMessage = ErrorMessage.builder().code(ex.getCode()).message(ex.getMessage()).origmesg(ex.getMessage()).build();
        return Mono.just(buildErrorResponse(ex.getStatusCode(), ErrorResponse.builder().populateErrors(true).errorLocation(appConfig.getName()).errorId(String.valueOf(UUID.randomUUID())).errorAt(LocalDateTime.now()).error(errorMessage).build()));
    }

    public static ResponseEntity<ErrorResponse> buildErrorResponse(HttpStatusCode status, ErrorResponse errorResp) {
        String errorCode = extractErrorCodes(errorResp);
        logErrorResponse(errorResp);
        return ResponseEntity.status(status).header("error_code", errorCode).body(errorResp);
    }
    private static String extractErrorCodes(ErrorResponse errorResponse) {
        if (errorResponse.getError() != null && StringUtils.isNotBlank(errorResponse.getError().getCode())) {
            return errorResponse.getError().getCode();
        } else if (errorResponse.getErrors() != null && !errorResponse.getErrors().isEmpty()) {
            return errorResponse.getErrors().stream()
                    .map(ErrorMessage::getCode)
                    .filter(StringUtils::isNotBlank)
                    .collect(Collectors.joining(","));
        }
        return "ERR_MPL_00999";
    }
    private static void logErrorResponse(ErrorResponse er) {
        log.error("ErrorResponse: {}",er);
    }
}