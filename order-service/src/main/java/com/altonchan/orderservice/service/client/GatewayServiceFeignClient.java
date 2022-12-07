package com.altonchan.orderservice.service.client;

import com.altonchan.orderservice.model.dto.request.NoticeNewOrderRequestDTO;
import com.altonchan.orderservice.model.dto.response.NoticeNewOrderResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("gateway-service")
public interface GatewayServiceFeignClient {

    @RequestMapping(method = RequestMethod.POST, value = "/order", consumes = "application/json")
    NoticeNewOrderResponseDTO noticeNewOrder(@RequestBody NoticeNewOrderRequestDTO requestDTO);
}
