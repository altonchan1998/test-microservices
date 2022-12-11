package com.altonchan.orderservice.mapper.interfaces;

import com.altonchan.orderservice.model.dto.InstrumentDTO;
import com.altonchan.orderservice.model.entity.Instrument;
import org.mapstruct.Mapper;

@Mapper
public interface InstrumentMapper extends MapperBase<Instrument, InstrumentDTO> {

}
