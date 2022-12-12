package com.altonchan.orderservice.mapper;

import com.altonchan.orderservice.model.dto.InstrumentDTO;
import com.altonchan.orderservice.model.entity.Instrument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InstrumentMapper extends MapperBase<Instrument, InstrumentDTO> {

}
