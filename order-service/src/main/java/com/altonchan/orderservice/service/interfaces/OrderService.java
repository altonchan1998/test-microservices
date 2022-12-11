package com.altonchan.orderservice.service.interfaces;

import com.altonchan.orderservice.model.dto.request.CreateOrderRequestDTO;
import com.altonchan.orderservice.model.entity.Order;

import java.util.Optional;
import java.util.UUID;

public interface OrderService {
    Order create(CreateOrderRequestDTO requestDTO);

    Optional<Order> findByClOrderId(UUID clOrderId);
}
