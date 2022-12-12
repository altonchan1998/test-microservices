package com.altonchan.orderservice.Initializer;

import com.altonchan.orderservice.Initializer.interfaces.Initializer;
import com.altonchan.orderservice.model.entity.Instrument;
import com.altonchan.orderservice.repository.InstrumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InstrumentInitializer implements Initializer {

    @Autowired
    private InstrumentRepository instrumentRepository;

    @Override
    public void run() {
        instrumentRepository.save(new Instrument("cfi-code-01"));
        instrumentRepository.save(new Instrument("cfi-code-02"));
        instrumentRepository.save(new Instrument("cfi-code-03"));
    }
}
