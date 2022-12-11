package com.altonchan.orderservice.model.dto;


import com.altonchan.orderservice.constant.ValidationMessages;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor @NoArgsConstructor
public class OrderQtyDataDTO {

    @Min(value = 0, message = ValidationMessages.MIN_ZERO)
    private BigDecimal orderQty;

    @Min(value = 0, message = ValidationMessages.MIN_ZERO)
    private BigDecimal cashOrderQty;

    @Min(value = 0, message = ValidationMessages.MIN_ZERO)
    private BigDecimal orderPercent;
}
