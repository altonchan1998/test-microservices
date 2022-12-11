package com.altonchan.orderservice.client;

import com.netflix.discovery.converters.Auto;
import feign.Feign;
import feign.FeignException;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.feign.FeignDecorators;
import io.github.resilience4j.feign.Resilience4jFeign;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@RequiredArgsConstructor
public class GatewayClientConfiguration {

    private final GatewayClientFallback gatewayClientFallback;

    @Bean
    @Scope("prototype")
    public Feign.Builder feignBuilder() {
        FeignDecorators decorators = FeignDecorators.builder()
                .withFallback(gatewayClientFallback, FeignException.class)
                .build();
        return Resilience4jFeign.builder(decorators);
    }
}
