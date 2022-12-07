package com.altonchan.gatewayservice.model.dto.request;


import com.altonchan.gatewayservice.constant.ValidationMessages;
import com.altonchan.gatewayservice.model.dto.InstrumentDTO;
import com.altonchan.gatewayservice.model.dto.OrderQtyDataDTO;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;


@Data
public class CreateOrderRequestDTO {

    @NotNull(message = ValidationMessages.NOT_NULL)
    @Size(min = 1, message = ValidationMessages.NOT_EMPTY)
    private List<InstrumentDTO> instrumentList;

    private Character side;

    private LocalDateTime transactTime = LocalDateTime.now();

    private List<OrderQtyDataDTO> orderQtyDataList;

    private Character ordType;

}
