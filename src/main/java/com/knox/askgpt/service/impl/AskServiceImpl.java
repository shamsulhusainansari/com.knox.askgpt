package com.knox.askgpt.service.impl;

import com.knox.askgpt.client.AskWebClient;
import com.knox.askgpt.config.OpenApiProperties;
import com.knox.askgpt.model.GenerateTextRequest;
import com.knox.askgpt.model.GenerateTextResponse;
import com.knox.askgpt.service.AskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Service
public class AskServiceImpl implements AskService {

    private final AskWebClient askWebClient;
    private final OpenApiProperties properties;

    public AskServiceImpl(AskWebClient askWebClient, OpenApiProperties properties) {
        this.askWebClient = askWebClient;
        this.properties = properties;
    }

    @Override
    public Mono<List<GenerateTextResponse>> askMe(GenerateTextRequest request) {
        request.setModel(properties.getModel());
        return askWebClient.handlePostRequest(request,properties.getUrl().getResponse(), new ParameterizedTypeReference<List<GenerateTextResponse>>() {});
    }
}
