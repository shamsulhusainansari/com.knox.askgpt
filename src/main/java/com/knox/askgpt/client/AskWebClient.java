package com.knox.askgpt.client;

import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class AskWebClient {
    private final WebClient.Builder webClientBuilder;
    public <T, R> Mono<R> handlePostRequest(
            T request,
            String url,
            ParameterizedTypeReference<R> responseType) {

        WebClient webClient = webClientBuilder.build();

        return webClient
                .post()
                .uri(url)
                .bodyValue(request)
                .retrieve()
                .bodyToMono(responseType);
    }
    public <T, R> Mono<R> handlePostRequest(T request, String url, Class<R> responseType) {
        WebClient webClient = webClientBuilder.build();
        return webClient
                .post()
                .uri(url)
                .bodyValue(request)
                .retrieve()
                .bodyToMono(responseType);
    }

    public <R> Mono<R> handleGetRequest(String url, Map<String, String> headers, Map<String, String> queryParams, Class<R> responseType) {
        WebClient webClient = webClientBuilder.build();

        return webClient
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(responseType);
    }
}
