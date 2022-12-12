package com.altonchan.orderservice.controller;

import com.altonchan.orderservice.model.dto.request.CreateOrderRequestDTO;
import com.altonchan.orderservice.client.GatewayClient;
import com.altonchan.orderservice.model.dto.response.CreateOrderResponseDTO;
import com.altonchan.orderservice.model.entity.Order;
import com.altonchan.orderservice.service.interfaces.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class OrderController {

    @Autowired
    private GatewayClient gatewayClient;

    @Autowired
    private OrderService orderService;

    @PostMapping("/order")
    public CreateOrderResponseDTO createOrder(
            @RequestBody
            @Valid CreateOrderRequestDTO createOrderRequestDTO
    ) {
        UUID clOrderId = orderService.create(createOrderRequestDTO).getClOrderID();

        Order order = gatewayClient.notifyNewOrder(clOrderId);

        return new CreateOrderResponseDTO(order.getClOrderID(), order.getStatus());
    }

}
