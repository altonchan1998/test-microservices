package com.altonchan.gatewayservice.controller;


import com.altonchan.gatewayservice.constant.ValidationMessages;
import com.altonchan.gatewayservice.model.entity.Order;
import com.altonchan.gatewayservice.model.enums.Status;
import com.altonchan.gatewayservice.repository.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class GatewayController {

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/order")
    public Order notifyNewOrder(
            @RequestParam
            @NotBlank(message = ValidationMessages.NOT_BLANK)
            UUID clOrderId
    ) {
        Order order = orderRepository.findById(clOrderId).orElseThrow(EntityNotFoundException::new);
        order.setStatus(Status.ACCEPTED);
        return orderRepository.save(order);
    }
}
