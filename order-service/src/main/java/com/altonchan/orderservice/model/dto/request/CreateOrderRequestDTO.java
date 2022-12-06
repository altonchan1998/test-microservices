package com.altonchan.orderservice.model.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateOrderRequestDTO {

    @NotNull
    private List<@Valid Instrument> instrumentList;

    @NotNull
    private Character side;

    @NotNull
    private LocalDateTime transactTime;

    @NotNull
    private List<@Valid OrderQtyDdata> orderQtyDdataList;

    @NotNull
    private Character ordType;

}
