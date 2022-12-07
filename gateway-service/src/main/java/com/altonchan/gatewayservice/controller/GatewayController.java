package com.altonchan.gatewayservice.controller;

import com.altonchan.gatewayservice.model.dto.request.NoticeNewOrderRequestDTO;
import com.altonchan.gatewayservice.model.dto.response.NoticeNewOrderResponseDTO;
import com.altonchan.gatewayservice.model.entity.Order;
import com.altonchan.gatewayservice.model.enums.Status;
import com.altonchan.gatewayservice.repository.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatewayController {

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/order")
    public NoticeNewOrderResponseDTO noticeNewOrder(@RequestBody @Valid NoticeNewOrderRequestDTO requestDTO) {
        Order order = orderRepository.findById(requestDTO.getClOrderID()).orElseThrow(EntityNotFoundException::new);
        order.setStatus(Status.ACCEPTED);
        orderRepository.save(order);

        return new NoticeNewOrderResponseDTO(order.getClOrderID(), order.getStatus());
    }
}
