package com.darlei.sportpredict.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.beans.factory.annotation.Value;

@Configuration
public class WebClientConfig {

    @Value("${football.api.base-url}")
    private String baseUrl;

    @Value("${football.api.key}")
    private String apiKey;

    @Bean
    public WebClient footballDataWebClient() {
        return WebClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader("X-Auth-Token", apiKey)
                .build();
    }
}
