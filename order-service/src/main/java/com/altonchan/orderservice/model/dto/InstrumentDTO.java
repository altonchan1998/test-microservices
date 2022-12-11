package com.altonchan.orderservice.model.dto;

import com.altonchan.orderservice.validator.CfiCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class InstrumentDTO {

    @CfiCode
    private String cfiCode;
}
