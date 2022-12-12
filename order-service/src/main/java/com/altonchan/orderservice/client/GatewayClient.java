package com.altonchan.orderservice.client;

import com.altonchan.orderservice.model.entity.Order;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.altonchan.orderservice.constant.ServiceName.GATEWAY_SERVICE;

@FeignClient(name = GATEWAY_SERVICE, configuration = GatewayClientConfiguration.class)
public interface GatewayClient {

    String notifyNewOrder = "notice-new-order";

    @PostMapping(value = "/order", consumes = "application/json")
    @Retry(name = notifyNewOrder)
    @CircuitBreaker(name = notifyNewOrder)
    Order notifyNewOrder(@RequestParam UUID clOrderId);
}
