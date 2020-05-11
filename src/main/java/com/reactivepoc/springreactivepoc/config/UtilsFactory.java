package com.reactivepoc.springreactivepoc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class UtilsFactory {

    private RestTemplate restTemplate;
    private WebClient webClient;

    @Bean
    public RestTemplate getRestTemplate() {
        restTemplate = new RestTemplate();
        return restTemplate;

    }

    @Bean
    public WebClient getWebClient() {
        webClient = WebClient.builder().build();
        return webClient;

    }

}
