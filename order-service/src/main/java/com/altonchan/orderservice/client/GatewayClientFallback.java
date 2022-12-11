package com.altonchan.orderservice.client;

import com.altonchan.orderservice.model.entity.Order;
import com.altonchan.orderservice.service.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GatewayClientFallback implements GatewayClient {

    @Autowired
    private OrderService orderService;

    @Override
    public Order noticeNewOrder(UUID clOrderId) {
        return orderService.findByClOrderId(clOrderId).orElse(null);
    }
}
