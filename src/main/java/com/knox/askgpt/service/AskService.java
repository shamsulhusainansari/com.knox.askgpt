package com.knox.askgpt.service;

import com.knox.askgpt.model.GenerateTextRequest;
import com.knox.askgpt.model.GenerateTextResponse;
import reactor.core.publisher.Mono;

import java.util.List;

public interface AskService {
    Mono<List<GenerateTextResponse>> askMe(GenerateTextRequest request);
}
