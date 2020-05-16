package com.reactivepoc.springreactivepoc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class UtilsFactory {

    private WebClient webClient;

    @Bean
    public WebClient getWebClient() {
        webClient = WebClient.builder().build();
        return webClient;
    }

}
