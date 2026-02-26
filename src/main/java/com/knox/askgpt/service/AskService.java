package com.knox.askgpt.service;

import com.knox.askgpt.model.GenerateTextRequest;
import com.knox.askgpt.model.GenerateTextResponse;
import reactor.core.publisher.Mono;

public interface AskService {
    Mono<GenerateTextResponse> askMe(GenerateTextRequest request);
}
