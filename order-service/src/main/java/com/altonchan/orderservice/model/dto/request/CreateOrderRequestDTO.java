package com.altonchan.orderservice.model.dto.request;

import com.altonchan.orderservice.constant.ValidationMessages;
import com.altonchan.orderservice.model.dto.InstrumentDTO;
import com.altonchan.orderservice.model.dto.OrderQtyDataDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;


@Data
public class CreateOrderRequestDTO {
//
//    @NotNull(message = ValidationMessages.NOT_NULL)
//    @Size(min = 1, message = ValidationMessages.NOT_EMPTY)
//    private List<InstrumentDTO> instrumentList;
//
//    private Character side;
//
//    private LocalDateTime transactTime = LocalDateTime.now();
//
//    private List<OrderQtyDataDTO> orderQtyDataList;
//
//    private Character ordType;

}
