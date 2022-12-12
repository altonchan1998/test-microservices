package com.altonchan.orderservice.client;

import feign.Feign;
import feign.FeignException;
//import feign.httpclient.ApacheHttpClient;
import io.github.resilience4j.circuitbreaker.CircuitBreakerOpenException;
import io.github.resilience4j.feign.FeignDecorators;
import io.github.resilience4j.feign.Resilience4jFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class GatewayClientConfiguration {

    @Autowired
    private GatewayClientFallback gatewayClientFallback;

    @Bean
    @Scope("prototype")
    public Feign.Builder feignBuilder() {
        FeignDecorators decorators = FeignDecorators.builder()
                .withFallback(gatewayClientFallback, CircuitBreakerOpenException.class)
                .withFallback(gatewayClientFallback, FeignException.class)
                .build();
        return Resilience4jFeign.builder(decorators);
    }
}
