package com.altonchan.orderservice.client;

import com.altonchan.orderservice.model.entity.Order;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@FeignClient(name = "gateway-service", configuration = GatewayClientConfiguration.class)
public interface GatewayClient {

    @RequestMapping(method = RequestMethod.PATCH, value = "/order", consumes = "application/json")
    @Retry(name = "notice-new-order", fallbackMethod = "fallback")
    Order noticeNewOrder(@RequestParam UUID clOrderId);

    default Order fallback(@RequestParam UUID clOrderId, Throwable t) {
        return new Order();
    };
}
