package com.example.backend.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import java.util.List;
import java.util.Map;

@Service
public class AiService {

    private final RestClient restClient;
    private final String model;

    public AiService(
            @Value("${huggingface.api.url:https://api-inference.huggingface.co/v1/chat/completions}") String apiUrl,
            @Value("${huggingface.api.key:}") String apiKey,
            @Value("${huggingface.api.model:meta-llama/Llama-3.1-8B-Instruct}") String model) {

        this.model = model;
        this.restClient = RestClient.builder()
                .baseUrl(apiUrl)
                .defaultHeader("Authorization", "Bearer " + apiKey)
                .defaultHeader("Content-Type", "application/json")
                .build();
    }

    public String generateResponse(String systemPrompt, String userPrompt) {
        Map<String, Object> requestBody = Map.of(
                "model", this.model,
                "messages", List.of(
                        Map.of("role", "system", "content", systemPrompt),
                        Map.of("role", "user", "content", userPrompt)));

        return restClient.post()
                .body(requestBody)
                .retrieve()
                .body(String.class);
    }
}