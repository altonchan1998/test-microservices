package com.altonchan.orderservice.service;

import com.altonchan.orderservice.mapper.OrderQtyDataMapper;
import com.altonchan.orderservice.model.dto.InstrumentDTO;
import com.altonchan.orderservice.model.dto.request.CreateOrderRequestDTO;
import com.altonchan.orderservice.model.entity.Instrument;
import com.altonchan.orderservice.model.entity.Order;
import com.altonchan.orderservice.model.entity.OrderQtyData;
import com.altonchan.orderservice.model.enums.Status;
import com.altonchan.orderservice.repository.InstrumentRepository;
import com.altonchan.orderservice.repository.OrderRepository;
import com.altonchan.orderservice.service.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackFor = Exception.class)
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private InstrumentRepository instrumentRepository;
    @Autowired
    private OrderQtyDataMapper orderQtyDataMapper;

    @Override
    public Order create(CreateOrderRequestDTO requestDTO) {
//        List<OrderQtyData> orderQtyDataList = orderQtyDataMapper.toEntity(requestDTO.getOrderQtyDataList());
//        List<Instrument> instrumentList = instrumentRepository.findByCfiCodeIn(
//                requestDTO.getInstrumentList().stream()
//                        .map(InstrumentDTO::getCfiCode)
//                        .collect(Collectors.toList())
//        );

        Order order = new Order();
        order.setStatus(Status.ACCEPTED);
//        order.setOrderQtyDataList(orderQtyDataList);
//        order.setInstrumentList(instrumentList);
        order.setSide(requestDTO.getSide());
        order.setOrdType(requestDTO.getOrdType());
        order.setTransactTime(requestDTO.getTransactTime());

        return orderRepository.save(order);
    }

    @Override
    public Optional<Order> findByClOrderId(UUID clOrderId) {
        return orderRepository.findById(clOrderId);
    }
}
