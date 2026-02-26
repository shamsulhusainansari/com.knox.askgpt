package com.knox.askgpt.controller;

import com.google.gson.Gson;
import com.knox.askgpt.model.GenerateTextRequest;
import com.knox.askgpt.model.GenerateTextResponse;
import com.knox.askgpt.service.AskService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
@Validated
public class AskController {

    private final AskService askService;
    @PostMapping("/askMe")
    public Mono<GenerateTextResponse> askMe(@RequestBody GenerateTextRequest request) {
        log.info("AskMe Request: {}", new Gson().toJson(request));
        return askService.askMe(request);
    }
}
