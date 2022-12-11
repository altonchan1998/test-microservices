package com.altonchan.orderservice.model.dto.request;

import com.altonchan.orderservice.constant.ValidationMessages;
import com.altonchan.orderservice.model.dto.InstrumentDTO;
import com.altonchan.orderservice.model.dto.OrderQtyDataDTO;
import com.altonchan.orderservice.model.entity.Instrument;
import com.altonchan.orderservice.model.entity.OrderQtyData;
import com.altonchan.orderservice.model.enums.OrdType;
import com.altonchan.orderservice.model.enums.Side;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Data
@AllArgsConstructor @NoArgsConstructor
public class CreateOrderRequestDTO {
    @NotNull(message = ValidationMessages.NOT_NULL)
    @Size(min = 1, message = ValidationMessages.NOT_EMPTY)
    private List<@Valid InstrumentDTO> instrumentList;

    @NotNull(message = ValidationMessages.INVALID_TYPE)
    private Side side;

    private LocalDateTime transactTime = LocalDateTime.now();

    @NotNull(message = ValidationMessages.NOT_NULL)
    @Size(min = 1, message = ValidationMessages.NOT_EMPTY)
    private List<@Valid OrderQtyDataDTO> orderQtyDataList;

    @NotNull(message = ValidationMessages.INVALID_TYPE)
    private OrdType ordType;

}
